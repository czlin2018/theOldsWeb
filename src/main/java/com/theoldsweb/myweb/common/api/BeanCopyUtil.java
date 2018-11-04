package com.theoldsweb.myweb.common.api;import lombok.extern.slf4j.Slf4j;import org.springframework.cglib.beans.BeanCopier;import java.util.Map;import java.util.concurrent.ConcurrentHashMap;/** * @Date: 2018 07 30 下午2:31 * @Desc: 高效属性拷贝工具类 */@Slf4jpublic class BeanCopyUtil {    /**     * 属性拷贝(目前只支持同属性名丶同数据类型的字段拷贝)     *     * @param source 源对象     * @param target 目标对象     */    public static void copy(Object source, Object target) {        try {            BeanCopier copier = getCopier(source.getClass(), target.getClass());            copier.copy(source, target, null);        } catch (Exception e) {            log.error("类型转换异常！[源对像:{}][目标对象:{}]", source, target, e);        }    }    /**     * 外层key为目标类target，内层key为当前源对象类source     */    private final static Map<Class<?>, ConcurrentHashMap<Class<?>, BeanCopier>> beanCopiers = new ConcurrentHashMap<>();    /**     * 获取Copier     *     * @param source     * @param target     * @return     */    private static BeanCopier getCopier(Class<?> source, Class<?> target) {        ConcurrentHashMap<Class<?>, BeanCopier> beanCopierMap = beanCopiers.get(target);        if (beanCopierMap == null) {            beanCopierMap = new ConcurrentHashMap<>(8);        }        BeanCopier beanCopier = beanCopierMap.get(source);        if (beanCopier == null) {            beanCopier = BeanCopier.create(source, target, false);            beanCopierMap.put(source, beanCopier);        }        beanCopiers.putIfAbsent(target, beanCopierMap);        return beanCopier;    }}
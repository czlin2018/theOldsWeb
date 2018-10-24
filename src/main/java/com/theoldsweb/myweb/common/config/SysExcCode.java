package com.theoldsweb.myweb.common.config;import com.theoldsweb.myweb.common.dto.ResultDto;/** * 错误码说明 * 错误码按照内部和外部服务分为两大类，内部指的是内部系统开发的错误码，外部指的是后续对外开放如对：APP组所提供的错误码； * <p> * 1.内部错误码分为系统错误码，业务错误码，通用错误码；错误码应用将封装成框架或者接口统一方便调用； * <p> * 2.错误码规范： * 第一位：系统错误码和业务错误码通过1和2开头，如：1xx，2xx * 第二位：数字按照递增分为：0权限系统，1配置系统，2PMS系统，3BAIS系统，4新零售系统……. * 第三位：由开发者自己根据模块来定制，他属于哪个模块的标识如0表示权限模块，1用户模块等等 * <p> * 3.系统错误码由开发者根据自己系统出现的内部异常来制定自己的错误码；业务错误码要根据业务的内涵返回确定的错误码 * <p> * 4.通用的错误码指的是常见的一些错误码包括http码，特定的业务错误码，如0表示成功，-1表示处理失败 * <p> * 新零售系统错误码补充说明： * １.基于前述错误码说明,新零售业务错误码前缀都为：24 * 2. * <p> * <p> * Created by tanghong on 2017/2/27. */public interface SysExcCode {    String RETAIL_SYS_PREFIX = "14";    String RETAIL_BUSINESS_PREFIX = "24";    /***     * 通用异常码定义在此代码块内，其他各个业务模块的异常码定义在相应的业务模块代码块内     */    class SysCommonExcCode {        public final static int SYS_SUCCESS = 0;        public final static int SYS_OK = 200;        public final static int SYS_ERROR = 601;        public final static int ARGUMENT_ERROR = 602;        public static final long SSO_PREFIX = Long.valueOf(1 + "01");        public final static ResultDto SYS_TOKEN_OUTDATED = new ResultDto(-100, "用户身份解析失败!");    }    /**     * 定义异常结果对象     */    class SysExcDtoModule {        public final static ResultDto SYS_OK = new ResultDto(SysCommonExcCode.SYS_OK, "OK");        public final static ResultDto SYS_ERROR = new ResultDto(SysCommonExcCode.SYS_ERROR, "sys failure");        public final static ResultDto NOT_DATA = new ResultDto(1001, "没有数据!");        public final static ResultDto GET_PERMS_FAILURE = new ResultDto(-101, "获取权限异常!");        public final static ResultDto SSO_VERIFY_FAILURE = new ResultDto(-102, "SSO客户端校验调用失败!");        public final static ResultDto GET_USER_PERMS_FAILURE = new ResultDto(-103, "获取用户权限失败!");    }    class RetailModule {        private final static String RETAIL_SELF = "2";        /**         * 参数错误<br>         */        public static final int NO_DEFAULT_CATEGORY = Integer.valueOf(RETAIL_BUSINESS_PREFIX + RETAIL_SELF + "001");        public static final int RETURE_PRICE_CANNOT_LARGE_THAN_RETAIL = Integer.valueOf(RETAIL_BUSINESS_PREFIX + RETAIL_SELF + "002");        public static final int ARGUMENT_ERROR = Integer.valueOf(RETAIL_BUSINESS_PREFIX + RETAIL_SELF + "003");    }    class ProviderOutputOrder {        public final static int PRICE_MODIFY_BY_OTHER = 245;    }    /**     * odoo模块码：3(第三位)     */    class OdooModule {        private final static String ODOO = "3";        public final static ResultDto SERVICE_NOT_AVAILABLE =                new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + ODOO + "001"), "无法获取odoo商城的sessionId!");        public final static ResultDto CONNECT_OVERTIME =                new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + ODOO + "002"), "odoo商城服务超时!");        public static final int ODOO_SESSSION_EXCEPTION = Integer.valueOf(RETAIL_BUSINESS_PREFIX + ODOO + "003");        public static final int ODOO_EXCEPTION = Integer.valueOf(RETAIL_BUSINESS_PREFIX + ODOO + "004");        public final static ResultDto VERIFY_FAIL =                new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + ODOO + "005"), "odoo数据同步任务签名校验失败!");    }    class WeChatAppModule {        private final static String WECHAT_APP = "4";        public final static ResultDto WECHAT_NOT_BIND_AIOT = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "001"), "微信没有绑定绿米+服务平台！");        public final static ResultDto WECHAT_INFO_VERIFY_FAIL = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "002"), "用户信息完整性校验失败，请重新获取！");        public final static ResultDto WECHAT_SESSION_KEY_TICKET_INVALID = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "003"), "weChatSessionKeyTicket 已失效！");        public final static ResultDto WECHAT_SESSION_KEY_REQUEST_FAIL = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "004"), "session_key 获取失败！");        public final static ResultDto WECHAT_BIND_AIOT_FAIL = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "005"), "微信绑定失败！");        public final static ResultDto WECHAT_ALREADY_BIND_AIOT = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "006"), "该微信已绑定过指定的账号,如果需要重新绑定，请先解绑！");        public final static ResultDto WECHAT_LOGIN_FAIL = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "007"), "微信登录失败！");        public final static ResultDto WECHAT_TICKET_VERIFY_FAIL = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "008"), "票据已失效！");        public final static ResultDto WECHAT_TICKET_INVALID = new ResultDto(Integer.valueOf(RETAIL_BUSINESS_PREFIX + WECHAT_APP + "009"), "当前票据非法！");    }}
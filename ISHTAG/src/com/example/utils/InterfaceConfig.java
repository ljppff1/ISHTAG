package com.example.utils;
/**
 * 
* Title: InterfaceConfig
* Description:访问网络URL通过本类来管�?
* Company: SD 
* @author luolei
* @date 2014�?6�?6�?
 */
public final class InterfaceConfig {

//	private final static String HOME_URL = "http://192.168.0.117:8080"; //正式�?
	private final static String HOME_URL = "http://192.168.0.132:8080"; //正式�?
	//private final static String HOME_URL = "http://192.168.0.101:8080"; // 测试�?
	//private final static String HOME_URL = "http://192.168.0.116:8080"; // 测试�?
	public static String LOGIN_URL = InterfaceConfig.HOME_URL
			+ "/soho/home/login.do";
	public static String SHOWAUDIT =InterfaceConfig.HOME_URL+"/soho/auditInterface/showAudit.do";
	public static String AUDITINFO =InterfaceConfig.HOME_URL+"/soho/auditInterface/auditInfo.do";
    public static String HAVINGAUDIT =InterfaceConfig.HOME_URL+"/soho/auditInterface/hasAuditOpts.do";
    public static String AUDIT =InterfaceConfig.HOME_URL+"/soho/auditInterface/auditData.do";
    public static String REAUDIT =InterfaceConfig.HOME_URL+"/soho/auditInterface/reAuditData.do";
    public static String SINGLEAUDIT =InterfaceConfig.HOME_URL+"/soho/auditInterface/auditDataNoProcess.do";
	
    //拍照上传文件
    public static final String UPLOADFILE = InterfaceConfig.HOME_URL+"/soho/atteInterface/track/savePhTrack.do";

     //请假 
	public static String LEAVERECORD = InterfaceConfig.HOME_URL
			+"/soho/atteInterface/leave/listforpage.do";
	public static String LEAVEAPPROVALAUDIT = InterfaceConfig.HOME_URL
			+ "/soho/home/login.do";
	//加班 
	public static String WORKOVERTIME = InterfaceConfig.HOME_URL
			+"/soho/atteInterface/overtime/listforpage.do";
	public static String WORKOVERTIMEAUDIT = InterfaceConfig.HOME_URL
			+ "/soho/home/login.do";
	//出差
	public static String TRAVELAPPROVAL = InterfaceConfig.HOME_URL
			+"/soho/atteInterface/travel/listforpage.do";
	public static String TRAVELAPPROVALAUDIT = InterfaceConfig.HOME_URL
			+ "/soho/home/login.do";
	//费用支出
	public static String COSTREPORTAPPROVAL = InterfaceConfig.HOME_URL
			+ "/soho/sale/salepayfeeinterface/querySalePayFeeForPage.do";
	public static String COSTREPORTAPPROVALDETAIL = InterfaceConfig.HOME_URL
			+ "/soho/sale/salepayfeeinterface/getSalePayFeeById.do";
	//营销报告
	public static String MARKETINGREPORTAPPROVAL = InterfaceConfig.HOME_URL
			+ "/soho/sale/salereportinterface/querySaleReportForPage.do";
	public static String MARKETINGREPORTAPPROVALAUDIT = InterfaceConfig.HOME_URL
			+ "/soho/home/login.do";
	// /querySalePayFeeForPage.do

	//公告
	public static String PUBLICNOTIFICATION = InterfaceConfig.HOME_URL
			+ "/soho/info/mediainterface/queryNewsForPage.do";
	public static String ATTENTIONNOTIFICATION = InterfaceConfig.HOME_URL
			+ "/soho/info/msginterface/queryMsgDetailForPage.do";
	public static String ATTENTIONNOTIFICATIONSEND = InterfaceConfig.HOME_URL
			+ "/soho/info/msginterface/saveMsg.do";

	
	//查询�?有打卡记�?
	public static String PUNCH_CARD=InterfaceConfig.HOME_URL
			+ "/soho/atteInterface/punch/listforpage.do";
	//添加打卡
	public static String PUNCH_CARD_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/punch/add.do";
	//查询请假记录
	public static String ASKFORLEAVE_LIST_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/leave/listforpage.do";
	//查询请假单号
	public static String ASKFORLEAVE_QUERYNUM_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/leave/initLeaveCode.do";
	//添加请假记录
	public static String ASKFORLEAVE_ADD_URL=InterfaceConfig.HOME_URL
				+"/soho/atteInterface/leave/saveOrUpdate.do";
	//删除请假记录
	public static String ASKFORLEAVE_DELETE_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/leave/delete.do";
	//文件上传
	public static String FILE_UPLOAD_URL=InterfaceConfig.HOME_URL
			+"";
	//查询公司�?有员工信�?
	public static String SEARCH_COMPANY=InterfaceConfig.HOME_URL
			+"/soho/employeeInterface/queryEmpBycompanyID.do";
	//查询�?有加班记�?
	public static String OVERTIME_LIST_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/overtime/listforpage.do";
	//新增或�?�修改加班记�?
	public static String OVERTIME_ADD_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/overtime/saveOrUpdate.do";
	//删除加班记录
	public static String OVERTIME_DELETE_URL=InterfaceConfig.HOME_URL
				+"/soho/atteInterface/overtime/delete.do";
	//出差记录查询
	public static String TRAVEL_LIST_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/travel/listforpage.do";
	//出差记录删除
	public static String TRAVEL_DELETE_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/travel/delete.do";
	//添加或�?�修改出差记�?
	public static String TRAVEL_ADD_URL=InterfaceConfig.HOME_URL
			+"/soho/atteInterface/travel/saveOrUpdate.do";
	//自动上传位置信息接口
	public static String AUTO_UPLOAD_POSTION_URL=InterfaceConfig.HOME_URL+"/soho/atteInterface/track/savePhTrack.do";
	//查询用户轨迹
	public static String LOAD_POSTION_URL=InterfaceConfig.HOME_URL+"/soho/atteInterface/track/queryPhoneTrack.do";
	//下载
	public static String DOWNLOAD_URL=InterfaceConfig.HOME_URL+"/soho/atteInterface/track/queryPhoneTrack.do";
	
	public static String LAST_USER_NAME = "LAST_USER_NAME";
	
	public static String LOGIN_USER_NAME = "LOGIN_USER_NAME";
	
	public static String PASSWORD = "PASSWORD";
	
	public static String ID="ID";
	
	public static String COMPANYID="COMPANYID";
	public static String POSITIONNAME="POSITIONNAME";

	public final static String EMPTY_STRING = null;

	public static Boolean IS_ALARMMANAGE_WORK=false;//控制闹钟是否运行
	
	public static int ALARMMANAGE_WORK_COUNT=1;//闹钟执行次数
	
	public static String resultCodeSuccess="200";
	
	public static int handlerSuccess=10086;
	
	public static int STARTHOUR = 9;
	public static int STARTMIN = 00;
	public static int ENDHOUR = 17;
	public static int ENDMIN = 00;
}

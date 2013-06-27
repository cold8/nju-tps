package Server.geass.database.Controller;

import java.util.ArrayList;
import java.util.Date;

import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;
import Shared.geass.dataPOJO.User;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-4-29
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public interface DatabaseControllerInterface {
    /**
     *
     * @return  错误信息
     */
    public abstract String getLastError();

    /**
     *
     * @param user
     * @return 操作是否成功
     */
    public abstract boolean submitUserInfo (User user);
    public abstract boolean deleteUser(User user);
    public abstract boolean modifyUserInfo(User user);

    /**
     *
     * @param userName
     * @return user
     */
    public abstract User getUserInfo(String userName);
    
    //modified by Plan
    /**
     * 插入一个新计划，自动设置计划的planid
     * @param title
     * @param begindate
     * @param enddate
     * @return 创建的新计划
     */
    public Plan createPlan(String username,String title, Date begindate, Date enddate);
    
    /**
     * 检查计划标题是否重复
     * @param title
     * @return 如果重复，返回空计划；如果不重复，返回该标题下的计划
     */
    public Plan getPlanInfo(String title);
    
    /**
     * 
     * @param planid
     * @param date
     * @return 指定id和日期的一天中所有时间段内容
     */
    public ArrayList<Phase> getDay(int planid, Date date);
    
    /**
     * 插入一个指定了id和日期的时间段内容
     * @param planid
     * @param date
     * @param begintime
     * @param endtime
     * @param cityname
     * @param site
     * @param transport
     * @param breakfast
     * @param lunch
     * @param dinner
     * @param comment
     * @return 是否成功插入
     */
    public boolean insertPhase(int planid, Date date, Date begintime,
			Date endtime, String cityname, String site, String transport,
			String breakfast, String lunch, String dinner, String comment);
    
    /**
     * 检查一个时间段是否已经存在
     * @param planid
     * @param date
     * @param beginTime
     * @param endTime
     * @return 是否已经存在
     */
    public boolean validPhase(int planid, Date date, Date beginTime,
			Date endTime);
    
    /**
     * @param planid
     * @return id指定的计划
     */
    public Plan getPlan(int planid);
    
    /**
     * 对指定id的计划，查找该id计划所含的几天中，哪一天所含有的Phase最多
     * @param planid
     * @return 含有最多Phase的那一天所含的Phase数量
     */
    public int getMaxCountOfPhases(int planid) ;
    
    /**
     * 对指定id的计划，查找由date指定的所有时间段Phase
     * @param planid
     * @param date
     * @return 该天所含的所有时间段数组
     */
    public ArrayList<Phase> getPhaseOfDay(int planid, Date date);
    
    /**
     * 
     * @return 获得系统支持的所有国家名称的字符串数组
     */
    public String[] getCountryList();
    
    /**
     * 查找由参数指定的某个国家的所有被系统支持的城市名称
     * @param countryname
     * @return 获得某个国家被系统支持的所有城市名称的字符串数组
     */
    public String[] getCityList(String countryname);
    
    /**
     * 删除由id指定的计划
     * @param planid
     * @return 删除成功与否
     */
    public boolean deletePlan(int planid);
    
    /**
     * 设置由id指定的计划的标题
     * @param planid
     * @param newPlantitle
     * @return 设置成功结果
     */
    public boolean setPlantitle(int planid, String newPlantitle);
    
    /**
     * 设置由id指定的计划的开始日期
     * @param planid
     * @param newStartdate
     * @return 设置结果
     */
    public boolean setPlanStartdate(int planid, Date newStartdate);
    
    /**
     * 设置由id指定的计划的结束日期
     * @param planid
     * @param newEnddate
     * @return 设置结果
     */
    public boolean setPlanEnddate(int planid, Date newEnddate);
    
    /**
     * 获得一个由参数指定的计划时间段
     * @param planid
     * @param begintime
     * @param endtime
     * @return
     */
    public Phase getPhaseRequest(int planid, Date begintime, Date endtime);
    
    /**
     * 获得所有计划的列表
     * @return 计划列表
     */
    public ArrayList<Plan> getPlanList();
    
    /**
     * 删除由phaseid参数指定的计划时间段
     * @param phaseid
     * @return 删除结果
     */
    public boolean deletePhase(int phaseid);
    
    /**
     * 删除指定planid的计划下，拥有指定日期date的所有Phase，清空当日的所有计划内容
     * @param planid
     * @param date
     * @return 清空结果
     */
    public boolean clearDay(int planid, Date date);
    public boolean checkPlanTitle(String plantitle);
    
}

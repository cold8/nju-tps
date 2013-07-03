package Server.geass.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Shared.geass.dataPOJO.Phase;
import Shared.geass.dataPOJO.Plan;


public class DBplan {

    Connection connection = null;

    /**
     * @param username
     * @param title
     * @param startdate
     * @param enddate
     * @return
     */
public Plan createPlan(String username,String title, Date startdate, Date enddate) {
        connection = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Plan plan =null;
        try{
            String sql =  "insert into plan (plantitle,username,startdate,enddate) values (?,?,?,?)";
            int id = -1;
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,title);
            pstmt.setString(2,username);
            pstmt.setTimestamp(3, new java.sql.Timestamp(startdate.getTime()));
            pstmt.setTimestamp(4, new java.sql.Timestamp(enddate.getTime()));
            pstmt.executeUpdate();
            System.out.println("执行："+sql);
            
            String sql1 = "select planid from plan where plantitle = ?";
            pstmt = connection.prepareStatement(sql1); 
            pstmt.setString(1,title);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
            	id = resultSet.getInt(1);
                plan = new Plan(id,title,username,startdate,enddate);
            }
            System.out.println("执行："+sql1);
            
        }catch (SQLException e){
            plan = null;
            e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }


        return plan;
	}

	/**
	 * 
	 * @param plantitle
	 * @return
	 */
	public Plan getPlanInfo(String plantitle) {
		Plan plan = null;
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from plan where plantitle = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, plantitle);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				plan = new Plan(resultSet.getInt("planid"),plantitle,resultSet.getString("username"),
						resultSet.getDate("startdate"),
						resultSet.getDate("enddate"));
			}
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }
		return plan;		
	}

	/**
	 * 
	 * @param planid
	 * @param date
	 * @return
	 */
	public ArrayList<Phase> getDay(int planid, Date date) {
		ArrayList<Phase> phases = new ArrayList<Phase>();
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from phase where planid = ? and date = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				phases.add(new Phase(planid,resultSet.getInt("phaseid"),resultSet.getDate("date"),
						new java.util.Date(resultSet.getTimestamp("begintime").getTime()),
						new java.util.Date(resultSet.getTimestamp("endtime").getTime()),
						resultSet.getString("cityname"),resultSet.getString("transport"),
						resultSet.getString("site"),resultSet.getString("breakfast"),
						resultSet.getString("lunch"),resultSet.getString("dinner"),
						resultSet.getString("comment")));

			}
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}
		
		return phases;
	}

	/**
	 * 需要检查数据库中已存在的Phase中是否存在planid,begintime,endtime完全相同的Phase
	 * 如果存在，则覆盖这个Phase，phaseid不变
	 * 如果不存在，则插入新的Phase
	 */
	public boolean insertPhase(int planid, Date date, Date begintime,
			Date endtime, String cityname, String site, String transport,
			String breakfast, String lunch, String dinner, String comment) {

        connection = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try{
            String query1 = "select * from phase where planid = ? and begintime = ? and endtime = ?";
            pstmt = connection.prepareStatement(query1);
            pstmt.setInt(1,planid);
            pstmt.setTimestamp(2,new java.sql.Timestamp(begintime.getTime()));
            pstmt.setTimestamp(3,new java.sql.Timestamp(endtime.getTime()));
            resultSet = pstmt.executeQuery();
            if(!resultSet.next()){
                String sql =  "insert into phase (planid,date,begintime,endtime,cityname,site,transport,breakfast,lunch,dinner,comment) values (?,?,?,?,?,?,?,?,?,?,?)";
                pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1,planid);
                pstmt.setDate(2,new java.sql.Date(date.getTime()));
                pstmt.setTimestamp(3,new java.sql.Timestamp(begintime.getTime()));
                pstmt.setTimestamp(4,new java.sql.Timestamp(endtime.getTime()));
                pstmt.setString(5,cityname);
                pstmt.setString(6,site);
                pstmt.setString(7,transport);
                pstmt.setString(8,breakfast);
                pstmt.setString(9,lunch);
                pstmt.setString(10,dinner);
                pstmt.setString(11,comment);
                pstmt.executeUpdate();
                System.out.println("执行："+sql);
            }else{
                System.out.println("用户名重复");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }

		return true;
	}
	
	/**
	 * 用util.Date类的equals()或者compareTo()方法很容易出错，因为fasttime值不一定相同
	 * 要比较util.Date类最好用toString()后转换的字符串来比较
	 */
	public boolean validPhase(int planid, Date date, Date beginTime,
			Date endTime) {
        connection = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try{
            String query1 = "select * from phase where planid = ? and begintime = ? and endtime = ?";
            pstmt = connection.prepareStatement(query1);
            pstmt.setInt(1,planid);
            pstmt.setTimestamp(2,new java.sql.Timestamp(beginTime.getTime()));
            pstmt.setTimestamp(3,new java.sql.Timestamp(endTime.getTime()));
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
            	if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
                DBConnection.freeDBConnection(connection);
            	return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }
		

		return true;
	}

	public Plan getPlan(int planid) {
		// TODO Auto-generated method stub
		Plan plan = null;
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try{
			String sql = "select * from plan where planid = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				plan = new Plan(resultSet.getString("plantitle"),resultSet.getString("username"),resultSet.getDate("startdate"),resultSet.getDate

("enddate"));
			}else
			System.out.println("执行：" + sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }

		return plan;
	}

	/**
	 * 查找planid所含的所有Phase
	 * 根据Phase.date 将Phase分在不同的日期下
	 * 比较每一个日期中，所含的Phase的数量
	 * 取最大的Phase的数量
	 */
	public int getMaxCountOfPhases(int planid) {
		// TODO Auto-generated method stub

		return 0;
	}

	public ArrayList<Phase> getPhaseOfDay(int planid, Date date) {
		ArrayList<Phase> phases = new ArrayList<Phase>();
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from phase where planid = ? and date = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				phases.add(new Phase(planid,resultSet.getInt("phaseid"),resultSet.getDate("date"),
						new java.util.Date(resultSet.getTimestamp("begintime").getTime()),
						new java.util.Date(resultSet.getTimestamp("endtime").getTime()),
						resultSet.getString("cityname"),resultSet.getString("transport"),
						resultSet.getString("site"),resultSet.getString("breakfast"),
						resultSet.getString("lunch"),resultSet.getString("dinner"),
						resultSet.getString("comment")));

			}
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}
		
		return phases;
	}

	public String[] getCountryList() {
		String[] countries = null;
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int i = 0;
		try {
			String sql = "select count(country) as ccount from city";
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				if(resultSet.getInt("ccount")!=0)
					countries = new String[resultSet.getInt("ccount")];
			}
			sql = "select distinct country from city";
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				countries[i++] = resultSet.getString("country");
			}
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}
		
		return countries;
	}

	
	public String[] getCityList(String countryname) {
		String[] cities = null;
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		System.out.println("dbplan getcity "+countryname);
		int i = 0;
		try {
			String sql = "select count(cityname) as ccount from city where country = ?";			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, countryname);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				if(resultSet.getInt("ccount")!=0){
					cities = new String[resultSet.getInt("ccount")];
				}
			}
			sql = "select cityname from city where country = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, countryname);		
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				//System.out.println(resultSet.getString("cityname"));
				cities[i++] = resultSet.getString("cityname");
			}
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}
		
		return cities;
	}

	public boolean deletePlan(int planid) {
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete * from plan where planid = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
			sql = "delete * from phase where planid = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}

		return true;
	}

	public boolean setPlantitle(int planid, String newPlantitle) {
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update plan set plantitle = ? where planid = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,newPlantitle);
			pstmt.setInt(2, planid);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}

		return true;
	}

	/**
	 * 如果新开始日期在原来开始日期之前，则直接设置；
	 * 如果新开始日期在原来开始日期之后，在原来结束日期之前，则删除从原来开始日期到新开始日期中间这部分数据,phase
	 */
	public boolean setPlanStartdate(int planid, Date newStartdate) {
		// TODO Auto-generated method stub
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update plan set startdate = ? where planid = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1,new java.sql.Date(newStartdate.getTime()));
			pstmt.setInt(2, planid);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
			
			sql = "delete * from phase where date < ?";
			pstmt = connection.prepareStatement(sql);
			DateFormat d = new SimpleDateFormat("yyyyy-MM-dd");
			String startdate = d.format(newStartdate);
			pstmt.setString(1,startdate);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}

		return true;
	}

	/**
	 * 如果新结束日期在原来结束日期之后，则直接设置；
	 * 如果新结束日期在原来结束日期之前，在原来开始日期之后，则删除从新结束日期到原来结束日期中间这部分数据,phase
	 */
	public boolean setPlanEnddate(int planid, Date newEnddate) {
		// TODO Auto-generated method stub

		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update plan set startdate = ? where planid = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1,new java.sql.Date(newEnddate.getTime()));
			pstmt.setInt(2, planid);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
			
			sql = "delete * from phase where date > ?";
			pstmt = connection.prepareStatement(sql);
			DateFormat d = new SimpleDateFormat("yyyyy-MM-dd");
			String startdate = d.format(newEnddate);
			pstmt.setString(1,startdate);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
		}

		return true;
	}

	/**
	 * 由planid,begintime,endtime确定
	 */
	public Phase getPhase(int planid, Date begintime, Date endtime) {
		// TODO Auto-generated method stub
		Phase phase = null;
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from phase where planid = ? and begintime = ? and endtime = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				phase = new Phase(planid, resultSet.getInt("phaseid"),resultSet.getDate("date"),
						new java.util.Date(resultSet.getTimestamp("begintime").getTime()),
						new java.util.Date(resultSet.getTimestamp("endtime").getTime()),
						resultSet.getString("cityname"),resultSet.getString("transport"),
						resultSet.getString("site"),resultSet.getString("breakfast"),
						resultSet.getString("lunch"),resultSet.getString("dinner"),
						resultSet.getString("comment"));

			}else{
				System.out.println("执行：" + sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return phase;

	}

	public ArrayList<Plan> getPlanList() {
		ArrayList<Plan> plans = new ArrayList<Plan>();
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from plan ";
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				plans.add(new Plan(resultSet.getString("plantitle"),resultSet.getString("username"),resultSet.getDate

("startdate"),resultSet.getDate("enddate")));
			}
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plans;
	}

	public boolean deletePhase(int phaseid) {
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		try {
			/*删除关联内容？*/
			String sql = "delete * from phase where phaseid = ? ";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, phaseid);
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	
	/**
	 * 不改变开始日期和结束日期，只删除所有拥有这个日期的Phase
	 */
	public boolean clearDay(int planid, Date date) {
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		try {
			/*删除关联内容？*/
			String sql = "delete * from phase where planid = ? and date = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, planid);
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.executeUpdate();
			System.out.println("执行：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}


/**
	 * 检查计划标题是否重复
	 * @param title
	 * @return 重复则返回false，否则返回true
	 */
	public boolean checkPlanTitle(String plantitle) {
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		boolean result = true;
		try {
			String sql = "select * from plan where plantitle = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, plantitle);
			resultSet = pstmt.executeQuery();
			if(resultSet.next())
				result = false;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
        
        public ArrayList<Plan> getPlanByuser(String username) {
		// TODO Auto-generated method stub
		Plan plan = null;
                ArrayList<Plan> planlist = new ArrayList<Plan>();
		connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try{
			String sql = "select * from plan where username = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, username);
			resultSet = pstmt.executeQuery();System.out.println(" userName 查询");
			if(resultSet.next()){
				plan = new Plan(resultSet.getString("plantitle"),resultSet.getString("username"),resultSet.getDate("startdate"),resultSet.getDate

("enddate"));
                                planlist.add(plan);
			}else
			System.out.println("执行：" + sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            DBConnection.freeDBConnection(connection);
        }

		return planlist;
	}

}

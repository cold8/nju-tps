package Client.geass.clientController.searchInfoController;

import java.util.ArrayList;

import Shared.geass.dataPOJO.City;

public class CityData {
 
	public ArrayList Getbyname(String[] nameList){
		ArrayList<City> cityList = new ArrayList<City>();
		if(nameList != null){
		/*	for(int i =0;i<list.length;i++)
				cityList.add(arg0);*/
			cityList.add(createCity());
		}
		return cityList ;
	}

public City createCity(){
	City ci = new City();
	ci.setCityname("南京");
	ci.setPicturehref("3.jpg");
	ci.setDescription(text);
	
	return ci ;
}
public ArrayList getbyseason(String season){
	ArrayList<City> cityList = new ArrayList<City>();
	if(season != null){
		/*	for(int i =0;i<list.length;i++)
				cityList.add(arg0);*/
			cityList.add(createCity());
		}
		return cityList ;
	 
}
String text ="南京历史悠久\n小吃有鸭血粉丝\n汤山葫芦洞古人类化石地点(南京人化石地点)\n江苏省文物保护单位。位于南京城东约30公里处江宁县汤山镇雷公山葫芦洞。1993年江宁县在对雷公山溶洞进行旅游开发挖掘时，于洞中发现猿人头骨化石2具、牙齿化石1枚和一些动物化石。南京市博物馆与北京大学考古系合作进行了科学发掘。研究与鉴定结果表明，南京人生活的地质时代为中更新世中期，距今35万年左右，在体质发展阶段上应属于人类演化的直立人阶段。南京人在我国古人类演化序列中的位置，应在北京人时期偏晚的阶段，而早于安徽和县人。南京直立人的出土是我国古人类及旧石器时代考古领域的重要发现，具有重大意义。 ";






}
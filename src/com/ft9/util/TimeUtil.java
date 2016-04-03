package com.ft9.util;



import java.util.Calendar;
import java.util.IllegalFormatConversionException;

/**
 * class name:TimeUtil <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2015�??12�??9�??
 * @author GElement)caiyicheng
 */
public class TimeUtil {
	public static int TIME_PERIOD=1;
	public static int DATE=2;
	public static String INTERNATIONAL="24";
	public static String AMPM="AMPM";
	private long year=-1;
	private long month=-1;
	private long day=-1;
	private long hour=-1;
	private long minute=-1;
	private long second=-1;
	private int timeType=TimeUtil.TIME_PERIOD;
	
	/**
	 * Method name: GetCurrentTime <BR>
	 * Description: GetCurrentTime <BR>
	 * Remark: <BR>
	 * @return  TimeUtil<BR>
	 */
	public static TimeUtil GetCurrentTime(){
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int day = c.get(Calendar.DAY_OF_MONTH); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		return new TimeUtil(year, month+1, day, hour, minute, second,TimeUtil.DATE);
	}
	
	/**
	 * Method name: isCurrentTimeOutOfLimit <BR>
	 * Description: isCurrentTimeOutOfLimit <BR>
	 * Remark: <BR>
	 * @param originalTime
	 * @param timeLimited
	 * @return  boolean<BR>
	 */
	public static boolean isCurrentTimeOutOfLimit(TimeUtil originalTime,String timeLimited){

		TimeUtil timePeriod=new TimeUtil(timeLimited);
		return TimeUtil.GetCurrentTime().greatThan(originalTime.add(timePeriod));
	}
	
	public static TimeUtil getTimeUtilByStandardDateFormat(String dateStr)throws Exception{
		String[] dateArr=dateStr.split("-");
		if(dateArr.length!=3){
			throw new IllegalArgumentException("The Format Can not be recognized"+dateStr);
		}
		TimeUtil timeUtil=new TimeUtil(dateArr[0]+"Y"+dateArr[1]+"M"+dateArr[2]+"D0h0m0s",TimeUtil.DATE);
		return timeUtil;
	}
	
	public static boolean checkIfDateFormatValid(String dateFormat){
		try {
			getTimeUtilByStandardDateFormat(dateFormat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * Method name: checkTimeInTimeInterval <BR>
	 * Description: Check Time In Time Interval<BR>
	 * Remark: <BR>
	 * @param originalTime
	 * @param mutualTime
	 * @param bias
	 * @return  boolean<BR>
	 */
	public static boolean checkTimeInTimeInterval(TimeUtil originalTime,TimeUtil checkTime,String mutualTime,int bias){
		if(originalTime==null||checkTime==null||mutualTime==null||bias<0){
			return false;
		}
		TimeUtil timePeriod=new TimeUtil(mutualTime);
		long second=timePeriod.toSecond();
		TimeUtil timeFloor=originalTime.addSecond((int) (second-bias));
		TimeUtil timeUpper=originalTime.addSecond((int) (second+bias));
		return !(checkTime.lessThan(timeFloor)||checkTime.greatThan(timeUpper));
	}
	
	public static boolean checkTimeInPeriod(TimeUtil startTime,TimeUtil endTime,TimeUtil checkTime){
		return !(checkTime.lessThan(startTime)||checkTime.greatThan(endTime));
	}
	
	public static boolean checkDateInPeriod(String startDate,String endDate,String checkDate){
		return checkDateAfter(startDate,checkDate)&&checkDateBefore(endDate,checkDate);
	}
	
	public static boolean checkDateAfter(String startDate,String checkDate){
		try {
			TimeUtil startDateTime=TimeUtil.getTimeUtilByStandardDateFormat(startDate);
			TimeUtil checkDateTime=TimeUtil.getTimeUtilByStandardDateFormat(checkDate);
			System.out.println(checkDateTime.lessThan(startDateTime));
			return !checkDateTime.lessThan(startDateTime);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean checkDateBefore(String endDate,String checkDate){
		try{
			TimeUtil checkDateTime=TimeUtil.getTimeUtilByStandardDateFormat(checkDate);
			TimeUtil endDateTime=TimeUtil.getTimeUtilByStandardDateFormat(endDate);
			return !checkDateTime.greatThan(endDateTime);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * Method name: TimeUtil<BR>
	 * Description: please write your description<BR>
	 * Remark: <BR>
	 * @param timeStr
	 * @throws IllegalArgumentException
	 * @throws IllegalFormatConversionException <BR>
	 */
	public TimeUtil(String timeStr)throws IllegalArgumentException,IllegalFormatConversionException{
		this.setTimeByString(timeStr);
	}
	/**
	 * Method name: TimeUtil<BR>
	 * Description: please write your description<BR>
	 * Remark: <BR>
	 * @param timeStr
	 * @param TimeType
	 * @throws IllegalArgumentException
	 * @throws IllegalFormatConversionException <BR>
	 */
	public TimeUtil(String timeStr,int TimeType)throws IllegalArgumentException,IllegalFormatConversionException{
		this.setTimeByString(timeStr, TimeType);
	}
	/**
	 * Method name: TimeUtil<BR>
	 * Description: please write your description<BR>
	 * Remark: <BR>
	 * @param Y
	 * @param M
	 * @param D
	 * @param h
	 * @param m
	 * @param s
	 * @param _timeType <BR>
	 */
	public TimeUtil(long Y,long M,long D,long h,long m,long s,int _timeType){
		setAllValues(Y,M,D,h,m,s,_timeType);
	}
	
	/**
	 * Method name: TimeUtil<BR>
	 * Description: please write your description<BR>
	 * Remark: <BR>
	 * @param right <BR>
	 */
	public TimeUtil(TimeUtil right){
		this.setAllValues(right.year,right.month,right.day,right.hour,right.minute,right.second,right.timeType);
	}
	/**
	 * Method name: TimeUtil <BR>
	 * Description: TimeUtil <BR>
	 * Remark: <BR>  void<BR>
	 */
	public TimeUtil() {
		
	}
	
	/**
	 * Method name: setAllValues <BR>
	 * Description: setAllValues <BR>
	 * Remark: <BR>
	 * @param Y
	 * @param M
	 * @param D
	 * @param h
	 * @param m
	 * @param s
	 * @param _timeType  void<BR>
	 */
	public void setAllValues(long Y,long M,long D,long h,long m,long s,int _timeType){
		this.setTimeType(_timeType);
		setYear(Y);
		setMonth(M);
		setDay(D);
		setHour(h);
		setMinute(m);
		setSecond(s);
	}

	/**
	 * Method name: setTimeByString <BR>
	 * Description: setTimeByString <BR>
	 * Remark: eg."2013Y2M5D12h23m"means 2013-2-5 12:23<BR>
	 * @param timeStr  void<BR>
	 */
	public void setTimeByString(String timeStr,int timeType)throws IllegalArgumentException,IllegalFormatConversionException{
		this.setTimeType(timeType);
		int i=0;String timeValue="";
		while(i<timeStr.length()){
			if(Character.isDigit(timeStr.charAt(i))){
				timeValue+=timeStr.charAt(i);
			}else{
				this.setTimeByTag(timeValue, timeStr.charAt(i));
				timeValue="";
			}
			++i;
		}
		if(!timeValue.equals("")){
			throw new IllegalArgumentException("Illegal Time String:"+timeStr);
		}
		
	}
	
	/**
	 * Method name: setTimeByString <BR>
	 * Description: setTimeByString <BR>
	 * Remark: <BR>
	 * @param timeStr  void<BR>
	 */
	public void setTimeByString(String timeStr){
		this.setTimeByString(timeStr, TimeUtil.TIME_PERIOD);
	}
	
	/**
	 * @Override
	 * @see java.lang.Object#toString() <BR>
	 * Method name: toString <BR>
	 * Description: please write your description <BR>
	 * Remark: <BR>
	 * @return  <BR>
	*/
	public String toString(){
		String timeStr="";
		if(year!=-1){
			timeStr+=year+"Y";
		}
		if(month!=-1){
			timeStr=timeStr+month+"M";
		}
		if(day!=-1){
			timeStr=timeStr+day+"D";
		}
		if(hour!=-1){
			timeStr=timeStr+hour+"h";
		}
		if(minute!=-1){
			timeStr=timeStr+minute+"m";
		}
		if(second!=-1){
			timeStr=timeStr+second+"s";
		}
		return timeStr;
	}

	/**
	 * Method name: toString <BR>
	 * Description: toString <BR>
	 * Remark: <BR>
	 * @param format
	 * @return  String<BR>
	 */
	public String toString(String format){
		return this.toString(format, TimeUtil.INTERNATIONAL);
	}
	/**
	 * Method name: toString <BR>
	 * Description: toString <BR>
	 * Remark: <BR>
	 * @param format
	 * @param timeSystem
	 * @return  String<BR>
	 */
	public String toString(String format,String timeSystem){
		if(timeSystem==null||("").equals(timeSystem)){
			timeSystem=TimeUtil.INTERNATIONAL;
		}
		if(format==null||("").equals(format)){
			return "";
		}
		
		String timeStr=format;
		if(year!=-1){
			timeStr=timeStr.replace("Y", year+"");
		}else{
			timeStr=timeStr.replace("Y", "");
		}
		
		
		if(month!=-1){
			timeStr=timeStr.replace("M", month+"");
		}else{
			timeStr=timeStr.replace("M","");
			
		}
		
		if(day!=-1){
			timeStr=timeStr.replace("D",day+"");
		}else{
			timeStr=timeStr.replace("D","");
		}
		
		if(hour!=-1){
			if(timeType==TimeUtil.DATE&&timeSystem.equals(AMPM)){
				if(hour>12){
					timeStr=timeStr.replace("h",(hour-12)+"");
				}else{
					timeStr=timeStr.replace("h",hour+"");
				}
			}else{
				timeStr=timeStr.replace("h",hour+"");
			}
				
			
		}else{
			timeStr=timeStr.replace("h","");
		}
		
		if(minute!=-1){
			timeStr=timeStr.replace("m",minute+"");
		}else{
			timeStr=timeStr.replace("m","");
		}
		
		if(second!=-1){
			timeStr=timeStr.replace("s",second+"");
		}else{
			timeStr=timeStr.replace("s","");
		}
		if(timeType==TimeUtil.DATE&&timeSystem.equals(AMPM)){
			if(hour>12){
				timeStr=timeStr+=" PM";
			}else{
				timeStr=timeStr+=" AM";
			}
		}
		return timeStr;
	}
	

	/**
	 * Method name: setTimeByTag <BR>
	 * Description: setTimeByTag <BR>
	 * Remark: <BR>
	 * @param value
	 * @param tag
	 * @throws IllegalArgumentException
	 * @throws IllegalFormatConversionException  void<BR>
	 */
	private void setTimeByTag(String value,char tag)throws IllegalArgumentException,IllegalFormatConversionException{
		if(value==null||("").equals(value)){
			value="0";
		}
		switch(tag){
		case 'Y':{
			long year=Integer.parseInt(value);
			setYear(year);
			break;
			}
		case 'M':{
			long month=Integer.parseInt(value);
			
			setMonth(month);
			break;
			}
		case 'D':{
			long day=Integer.parseInt(value);
			setDay(day);
			break;
			}
		case 'h':{
			long hour=Integer.parseInt(value);
			setHour(hour);
			break;
			}
		case 'm':{
			long minute=Integer.parseInt(value);
			setMinute(minute);
			break;
		}
		case 's':{
			long second=Integer.parseInt(value);
			setSecond(second);
			break;
		}
		default:{
			throw new IllegalFormatConversionException(tag,TimeUtil.class);
		}
		}
	}
	
	/**
	 * Method name: isLeapYear <BR>
	 * Description: isLeapYear <BR>
	 * Remark: <BR>
	 * @return  boolean<BR>
	 */
	public boolean isLeapYear(){
		if(year==-1){
			return false;
		}else if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Method name: getDaysNumberByMonth <BR>
	 * Description: getDaysNumberByMonth <BR>
	 * Remark: <BR>
	 * @param month
	 * @return  int<BR>
	 */
	public int getDaysNumberByMonth(int month){
		switch (month){
		case 1:return 31;
		case 2:{
			if(isLeapYear()){
				return 29;
			}else{
				return 28;
			}
		}
		case 3:return 31;
		case 4:return 30;
		case 5:return 31;
		case 6:return 30;
		case 7:return 31;
		case 8:return 31;
		case 9:return 30;
		case 10:return 31;
		case 11:return 30;
		case 12:return 31;
		default:return -1;
		}
	}
	/**
	 * Method name: getYear <BR>
	 * Description: please write your description <BR>
	 * @return long <BR>
	 */
	public long getYear() {
		return year;
	}

	/**
	 * Method name: setYear <BR>
	 * Description: please write your description <BR>
	 * @param  year long <BR>
	 */
	public void setYear(long year)throws IllegalArgumentException {
		if(year<0){
			throw new IllegalArgumentException("Illegal year:"+year);
		}
		this.year = year;
	}

	/**
	 * Method name: getMonth <BR>
	 * Description: please write your description <BR>
	 * @return long <BR>
	 */
	public long getMonth() {
		return month;
	}

	/**
	 * Method name: setMonth <BR>
	 * Description: please write your description <BR>
	 * @param  month long <BR>
	 */
	public void setMonth(long month)throws IllegalArgumentException{
		if(timeType==TimeUtil.DATE&&(month>12||month<=0)||month<0){
			throw new IllegalArgumentException("Illegal Month:"+month);
		}
		this.month = month;
	}

	/**
	 * Method name: getDay <BR>
	 * Description: please write your description <BR>
	 * @return long <BR>
	 */
	public long getDay() {
		return day;
	}

	/**
	 * Method name: setDay <BR>
	 * Description: please write your description <BR>
	 * @param  day long <BR>
	 */
	public void setDay(long day)throws IllegalArgumentException,IllegalStateException {
		if(day<0){
			throw new IllegalArgumentException("Illegal Day:"+day);
		}
		if(timeType==TimeUtil.DATE&&year==-1){
			throw new IllegalStateException("you must set year first");
		}
		if(timeType==TimeUtil.DATE&&month==-1){
			throw new IllegalStateException("you must set month first");
		}
		if(month!=-1&&year!=-1){
			if(timeType==TimeUtil.DATE&&this.getDaysNumberByMonth((int) month)<day){
				throw new IllegalArgumentException("Illegal Day:"+day);
			}
		}
		this.day = day;
	}

	/**
	 * Method name: getHour <BR>
	 * Description: please write your description <BR>
	 * @return long <BR>
	 */
	public long getHour() {
		return hour;
	}

	/**
	 * Method name: setHour <BR>
	 * Description: please write your description <BR>
	 * @param  hour long <BR>
	 */
	public void setHour(long hour)throws IllegalArgumentException {
		if(timeType==TimeUtil.DATE&&hour>23||hour<0){
			throw new IllegalArgumentException("Illegal hour:"+hour);
		}
		this.hour = hour;
	}

	/**
	 * Method name: getMinute <BR>
	 * Description: please write your description <BR>
	 * @return long <BR>
	 */
	public long getMinute() {
		return minute;
	}

	/**
	 * Method name: setMinute <BR>
	 * Description: please write your description <BR>
	 * @param  minute long <BR>
	 */
	public void setMinute(long minute)throws IllegalArgumentException {
		if((timeType==TimeUtil.DATE&&minute>60)||minute<0){
			throw new IllegalArgumentException("Illegal minute:"+minute);
		}
		this.minute = minute;
	}

	/**
	 * Method name: getSecond <BR>
	 * Description: please write your description <BR>
	 * @return long <BR>
	 */
	public long getSecond() {
		
		return second;
	}

	/**
	 * Method name: setSecond <BR>
	 * Description: please write your description <BR>
	 * @param  second long <BR>
	 */
	public void setSecond(long second) {
		if((timeType==TimeUtil.DATE&&second>60)||second<0){
			throw new IllegalArgumentException("Illegal second:"+second);
		}
		this.second = second;
	}



	/**
	 * Method name: getTimeType <BR>
	 * Description: please write your description <BR>
	 * @return int <BR>
	 */
	public int getTimeType() {
		return timeType;
	}



	/**
	 * Method name: setTimeType <BR>
	 * Description: please write your description <BR>
	 * @param  timeType int <BR>
	 */
	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}
	

	/**
	 * Method name: equalsTo <BR>
	 * Description: equalsTo <BR>
	 * Remark: <BR>
	 * @param right
	 * @return
	 * @throws IllegalArgumentException  boolean<BR>
	 */
	public boolean equalsTo(TimeUtil right)throws IllegalArgumentException{
		if(this.timeType!=right.timeType){
			throw new IllegalArgumentException("Can't compare time period to date");
		}
		return second==right.second&&
			   minute==right.minute&&
			   hour==right.hour&&
			   day==right.day&&
			   month==right.month&&
			   year==right.year;
	}
	
	/**
	 * Method name: greatThan <BR>
	 * Description: greatThan <BR>
	 * Remark: <BR>
	 * @param right
	 * @return
	 * @throws IllegalArgumentException  boolean<BR>
	 */
	public boolean greatThan(TimeUtil right)throws IllegalArgumentException{
		if(this.timeType!=right.timeType){
			throw new IllegalArgumentException("Can't compare time period to date");
		}
		if(!(year==right.year)){
			return year>right.year;
		}else if(!(month==right.month)){
			return month>right.month;
		}else if(!(day==right.day)){
			return day>right.day;
		}else if(!(hour==right.hour)){
			return hour>right.hour;
		}else if(!(minute==right.minute)){
			return minute>right.minute;
		}else{
			return second>right.second;
		}
	}
	
	/**
	 * Method name: lessThan <BR>
	 * Description: lessThan <BR>
	 * Remark: <BR>
	 * @param right
	 * @return
	 * @throws IllegalArgumentException  boolean<BR>
	 */
	public boolean lessThan(TimeUtil right)throws IllegalArgumentException{
		return !(this.greatThan(right)||this.equalsTo(right));
	}
	
	
	
	
	/**
	 * Method name: addSecond <BR>
	 * Description: addSecond <BR>
	 * Remark: <BR>
	 * @param s
	 * @return
	 * @throws IllegalArgumentException  TimeUtil<BR>
	 */
	public TimeUtil addSecond(int s) throws IllegalArgumentException{
		if(timeType==DATE){
			if(second==-1){
				second=0;
			}
			int addMinute=s/60;
			int addSecond=s%60;
			if((addSecond+second)>=60){
				return new TimeUtil(year,month,day,hour,minute,(second+addSecond)%60,timeType).addMinute(addMinute+(int)(second+addSecond)/60);
			}else{
				return new TimeUtil(year,month,day,hour,minute,(second+addSecond)%60,timeType).addMinute(addMinute);
			}
		}else{
			if(second==-1){
				second=0;
			}
			return new TimeUtil(year,month,day,hour,minute,second+s,timeType);
		}
	}

	/**
	 * Method name: addMinute <BR>
	 * Description: addMinute <BR>
	 * Remark: <BR>
	 * @param m
	 * @return
	 * @throws IllegalArgumentException  TimeUtil<BR>
	 */
	public TimeUtil addMinute(int m)throws IllegalArgumentException{
		if(minute==-1){
			minute=0;
		}
		if(timeType==DATE){
			int addHour=m/60;
			int addMinute=m%60;
			if((addMinute+minute)>=60){
				return new TimeUtil(year,month,day,hour,(addMinute+minute)%60,second,timeType).addHour(addHour+(int)(addMinute+minute)/60);
			}else{
				return new TimeUtil(year,month,day,hour,(addMinute+minute)%60,second,timeType).addHour(addHour);
			}
		}else{
			return new TimeUtil(year,month,day,hour,minute+m,second,timeType);
		}
	}
	
	/**
	 * Method name: addHour <BR>
	 * Description: addHour <BR>
	 * Remark: <BR>
	 * @param H
	 * @return
	 * @throws IllegalArgumentException  TimeUtil<BR>
	 */
	public TimeUtil addHour(int H)throws IllegalArgumentException{
		if(hour==-1){
			hour=0;
		}
		if(timeType==DATE){
			int addDay=H/24;
			int addHour=H%24;
			if(addHour+hour>=24){
				return new TimeUtil(year,month,day,(addHour+hour)%24,minute,second,timeType).addDay(addDay+(int)(addHour+hour)/24);
			}else{
				return new TimeUtil(year,month,day,(addHour+hour)%24,minute,second,timeType).addDay(addDay);
			}
		}else{
			return new TimeUtil(year,month,day,hour+H,minute,second,timeType);
		}
	}
	
	/**
	 * Method name: addDay <BR>
	 * Description: addDay <BR>
	 * Remark: <BR>
	 * @param D
	 * @return
	 * @throws IllegalArgumentException  TimeUtil<BR>
	 */
	public TimeUtil addDay(int D)throws IllegalArgumentException{
		if(day==-1){
			day=0;
		}
		if(timeType==DATE){
			int daysOfThisMonth=this.getDaysNumberByMonth((int) month);
			if(D+day>daysOfThisMonth){
				return new TimeUtil(year,month,1,hour,minute,second,timeType).addMonth(1).addDay((int)(D+day-daysOfThisMonth-1));
			}else{
				return new TimeUtil(year,month,day+D,hour,minute,second,timeType);
			}
		}else{
			return new TimeUtil(year,month,day+D,hour,minute,second,timeType);
		}
	}
	
	/**
	 * Method name: addMonth <BR>
	 * Description: addMonth <BR>
	 * Remark: <BR>
	 * @param M
	 * @return
	 * @throws IllegalArgumentException  TimeUtil<BR>
	 */
	public TimeUtil addMonth(int M)throws IllegalArgumentException{
		if(month==-1){
			month=0;
		}
		if(timeType==DATE){
			int addYear=M/12;
			int addMonth=M%12;
			if(addMonth+month>12){
				if(getDaysNumberByMonth((int)(month+addMonth)%12)>=day){
					return new TimeUtil(year,(month+addMonth)%12,day,hour,minute,second,timeType).addYear(addYear+(int)(month+addMonth)/12);
				}else{
					return new TimeUtil(year,(month+addMonth)%12+1,day%getDaysNumberByMonth((int)(month+addMonth)%12),hour,minute,second,timeType).addYear(addYear+(int)(month+addMonth)/12);
				}
				
			}else{
				return new TimeUtil(year,month+addMonth,day,hour,minute,second,timeType).addYear(addYear);
			}
		}else{
			return new TimeUtil(year,month+M,day,hour,minute,second,timeType);
		}
		
	}
	
	/**
	 * Method name: add <BR>
	 * Description: add <BR>
	 * Remark: <BR>
	 * @param right
	 * @return
	 * @throws IllegalArgumentException  TimeUtil<BR>
	 */
	public TimeUtil add(TimeUtil right)throws IllegalArgumentException{
		if((this.timeType==right.timeType&&timeType==TimeUtil.DATE)||(this.timeType==TimeUtil.TIME_PERIOD&&right.timeType==TimeUtil.DATE)){
			throw new IllegalArgumentException("Invalid add operation");
		}
		TimeUtil newTime=new TimeUtil(this.toString(),this.getTimeType());
		if(right.getSecond()!=-1){
			newTime=newTime.addSecond((int) right.getSecond());
		}
		if(right.getMinute()!=-1){
			newTime=newTime.addMinute((int)right.getMinute());
		}
		if(right.getHour()!=-1){
			newTime=newTime.addHour((int)right.getHour());
		}
		if(right.getDay()!=-1){
			newTime=newTime.addDay((int)right.getDay());
		}
		if(right.getMonth()!=-1){
			newTime=newTime.addMonth((int)right.getMonth());
		}
		if(right.getYear()!=-1){
			newTime=newTime.addYear((int)right.getYear());
		}
		return newTime;
	}

	
	/**
	 * Method name: addYear <BR>
	 * Description: addYear <BR>
	 * Remark: <BR>
	 * @param Y
	 * @return  TimeUtil<BR>
	 */
	public TimeUtil addYear(int Y){
		if(year==-1){
			year=0;
		}
		return new TimeUtil(year+Y,month,day,hour,minute,second,timeType);
		
	}
	
	/**
	 * Method name: toSecond <BR>
	 * Description: toSecond <BR>
	 * Remark: <BR>
	 * @return  long<BR>
	 */
	public long toSecond(){
		long sec=0;
		if(year!=-1){
			sec+=year*31558150;
		}
		if(month!=-1){
			sec+=31558150/12*month;
		}
		if(day!=-1){
			sec+=86400*day;
		}
		if(hour!=-1){
			sec+=3600*hour;
		}
		if(minute!=-1){
			sec+=60*hour;
		}
		if(second!=-1){
			sec+=second;
		}
		return sec;
	}
	
	public String getDate(){
		return year+"-"+month+"-"+day;
	}
}

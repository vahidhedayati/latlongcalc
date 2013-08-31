package grails.groovy.plugin.latlongcalc
import static java.lang.Math.cos;
import static java.lang.Math.abs;
class CalcLatLong {
	
	double longtmin,longtmax,latmin,latmax
	String slongtmin,slongtmax,slatmin,slatmax
	String longt,lat,range
	
	
	public String Result() {
		double radius=DoubleParser(range)
		double dlat=DoubleParser(lat)
		double dlongt=DoubleParser(longt)
		latmin= dlat -(radius/69)
		latmax= dlat +(radius/69)
		longtmin= dlongt - radius/abs(cos(deg2rad(dlat))*69)
		longtmax= dlongt + radius/abs(cos(deg2rad(dlat))*69)
		slatmin=Double.toString(latmin)
		slatmax=Double.toString(latmax)
		slongtmin=Double.toString(longtmin)
		slongtmax=Double.toString(longtmax)
		
		return "[ latmin:"+slatmin+", latmax:"+slatmax+", longtmin:"+slongtmin+", longtmax:"+slongtmax+" ]"
		
	}

	
	private double DoubleParser(String value) {
		 double dret=0
		 Boolean isvalid=true
		 try {
			 Double.parseDouble(value)
		 } catch (NumberFormatException e) {
			 isvalid=false
		 }
		 if (isvalid) {
			 dret=Double.valueOf(value).doubleValue();
		 }
		return dret
	}
	
	
	
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0)
	}
	
}

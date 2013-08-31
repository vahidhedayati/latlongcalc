package grails.plugin.latlongcalc

class CalcLatLongTests extends GroovyTestCase {

	void testGoodInput() {
		CalcLatLong cl = new CalcLatLong()
		def values = cl.parse(30, 10.810547, 4.017699)
		assertEquals 11.2464007390, values.lonmax, 0.000000001
		assertEquals 10.3746932609, values.lonmin, 0.000000001
		assertEquals  3.5829163913, values.latmin, 0.000000001
		assertEquals  4.4524816086, values.latmax, 0.000000001
	}
}

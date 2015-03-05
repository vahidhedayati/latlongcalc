package grails.plugin.latlongcalc

import grails.plugins.Plugin

class LatlongcalcGrailsPlugin extends Plugin {
	def grailsVersion = "3 > *"
	def title = "Latitude Longitude Range calculator"
	def author = "Vahid Hedayati"
	def authorEmail = "badvad@gmail.com"
	def description = 'Grails plugin which given a range a longitude and latitude value will retun min/max values of longitude and latitude'
	def documentation = "http://grails.org/plugin/latlongcalc"
	def license = "Apache-2.0"
	def issueManagement = [system: 'GITHUB', url: 'https://github.com/vahidhedayati/latlongcalc/issues']
	def scm = [url: 'https://github.com/vahidhedayati/latlongcalc']
}

# sgsim-ingenias
A demonstration of agent based control of a SmartGrid. It launches a smartgrid emulation and permits external processes to connect, probe, and send orders to different controllable devices inside. The template uses INGENIAS to define those external processes as agents. 

This demo has been tested only in Linux. It requires JDK 1.7, ant, and maven properly installed:

- Define environment variable M2_HOME to point at the Maven home
- Define JAVA_HOME variable to point at the JDK home. Full JDK is required, not just JRE

#Instructions

First of all, run a "mvn compile"

Then, run the runSmartGrid.sh script to launch the SmartGrid realtime simulation

In another console in the same path, run the jade platform with "ant runjade"

Finally, you can choose which deployment to execute

* run "ant runSampleCase" to launch the two agent configuration.
* run "ant runFullCase" to launch the seven agent deployment

#Development

To check and edit the agent specification, run "ant edit". Go to http://ingenias.sf.net for more instructions about INGENIAS and how to compile/deploy this kind of systems.

The smartgrid simulator can be checked and downloaded at http://sgsimulator.sf.net.

#Credits

This software is one of the results of the MIRED-CON project made by the GRASIA group on behalf the UCM. The project main investigator from UCM was Jorge J. Gomez-Sanz. The software was developed by Sandra García Rodríguez, Nuria Cuartero Soler, and Jorge J. Gomez-Sanz.

The base simulation is made with GridLab-D. We thank the developers of this great framework their support for dealing with some bugs and questions we had along the development.


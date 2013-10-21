TP3 - TCHAT JAVA

authors : Nicolas DAVID and Sylvain PALOMINOS

============================================================================================
HOW TO USE : 

-local : 
	run the server with the command prompt
	run the client with the client.jar
	specify the path of the server
	enjoy !
	
-network : 
	run the server with the command prompt
	run the client on another machine
	specify the path of the distant server (works for several devices)
	tchat !
	
============================================================================================
if you want to use the code itself, install the library qt jambi

/!\ you must work with a 32bit version of your IDE or it will not work ! 
for instance : 
--->    http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/kepler/SR1/eclipse-standard-kepler-SR1-win32.zip   <----


============================================================================================
in the command prompt,

- launch cmd.exe
- use command "start rmiregistry" to initiate the registry if it did not work
- cd to tchat/bin (eclipse) or tchat/build/classes (netbeans) or somwehere else... (.class nedded)
- use command to launch the .java "java -Djava.security.policy=policy.txt serveur.Serveur" (place policy.txt in the current folder)
- you need to adapt the path of the server and the client in serveur.class and client.class
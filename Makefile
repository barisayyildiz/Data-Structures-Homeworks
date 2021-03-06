run:
	javac Main.java
	java Main
	rm *.class

clear:
	rm ./lib/*.class
	rm ./lib/user/*.class
	rm ./lib/furniture/*.class
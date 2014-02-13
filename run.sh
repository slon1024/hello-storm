[ -d log ] || mkdir log

echo  "compile"
mvn clean compile > log/compile.log
echo  "run"
mvn exec:java -Dexec.mainClass=HelloStormTopology | grep -v '\[' 2>log/error.log

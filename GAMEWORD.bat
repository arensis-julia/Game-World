setlocal
cd /d %~dp0
chcp 65001
MODE con cols=170 lines=63
javac *.java -encoding UTF-8
java -Dfile.encoding=utf-8 GameWordMain
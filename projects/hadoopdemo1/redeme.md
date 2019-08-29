# 统计输入文件中的单词出现的次数
- 输入文件格式
````
cui shibing is good person
cui shibing is not good person
````
- 输出文件格式
````
cui	2
good	2
is	2
not	1
person	2
shibing	2
````
- 运行命令
````
hadoop jar ./projects/hadoopdemo1/target/hadoopdemo1-1.0.jar cui.shibing.App ./inputs/words.txt ./outputs/
````

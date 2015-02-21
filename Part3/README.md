#Simplified PageRank 

###Algorithm
Assume a universe of web pages: A, B, C and D, a page can have only one link to another page.<br>

Initialize:<br>
A, B, C, D are initialized to the same value for all pages, i.e. 0.25

Iteration:<br>
PR(A) = PR(B) * (B->A)/(B.out) + PR(C) * (C->A)/(C.out) + PR(D) * (D->A)/(D.out)<br>
PR(B) = PR(A) * (A->B)/(A.out) + PR(C) * (C->B)/(C.out) + PR(D) * (D->B)/(D.out)<br>
PR(C) = PR(A) * (A->C)/(A.out) + PR(B) * (B->C)/(B.out) + PR(D) * (D->C)/(D.out)<br>
PR(D) = PR(A) * (A->D)/(A.out) + PR(B) * (B->D)/(B.out) + PR(C) * (C->D)/(D.out)<br>

###HDFS commands & run jar
#####Overview
File System shell includes commands that directly interact with HDFS. FS shell is invoked by
<pre>
hadoop fs [args]
</pre>
#####mkdir
make directory
<pre>
hadoop fs -mkdir [directory]
</pre>

#####ls
list files of current directory
<pre>
hadoop fs -ls
</pre>

#####lsr
list files recursively
<pre>
hadoop fs -lsr
</pre>

#####put
copy single src, or multiple srcs from local file system to the destination file system
<pre>
hadoop fs -put [local file path] [hdfs file path]
</pre>

#####get
copy files to local file system
<pre>
hadoop fs -get 
</pre>

#####rm
delete files
<pre>
hadoop fs -rm
</pre>

#####rmr
delete files recursively
<pre>
hadoop fs -rmr
</pre>

#####run Hadoop with jar
<pre>
hadoop jar [.jar file] [parameters]
</pre>

###MapReduce
#####Mapper 
Takes in  a line of record in the format of: <br>
<pre>
[source page] [linked page1] [linked page2] [value of source before this iteration]
</pre>
after parsing the record, 
<pre>
emit(linked page, [source pr]/[number of out links])
</pre>
in order to keep track of the linked pages for the next iteration, 
<pre>
emit([source page], [all linkedpages])
</pre>
#####Reducer 
Takes in a page and its emitted pr values as well as its linked pages.
<pre>
[source page] [linked pages]
[linked page] [a part of pr]
</pre>
parse them, add up all pr values of the same linked page. 
<pre>
emit([source page], [all linked pages] + [new pr value])
</pre>
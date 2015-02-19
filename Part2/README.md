#CountWords

###Overview
Given a large amount of tweets, count number of appearance of certain words.

Apache Hadoop 2.6.0

###Files
<dl>
<dt>CountWords.java</dt>
<dd>main function, specify job properties, mapper, reducer</dd>
<dt>CountWordsMapper.java</dt>
<dd>extends Mapper, overrides map function taking in key, value and context, parses tweets, emits word and 1</dd>
<dt>CountWordsReducer.java</dt>
<dd>extends Reducer, overrides reduce function taking in key, values, context, computes times</dd>

###Hadoop parameters
<b>map(key, value, context)</b><br>
	key: input key<br>
	value: input value (one tweet)<br>
	context: write to emit word and 1<br>
	
<b>reduce(key, values, context)</b><br>
	key: word<br>
	values: number of appearance<br>
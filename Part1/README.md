#First Mapreduce Program

###Overview
Given a large amount of records of temperature, parse the records and compute the maximum temperature of each year.

Apache Hadoop 2.6.0

###Files
<dl>
<dt>MaxTemperature.java</dt>
<dd>main function, specify job properties, mapper, reducer</dd>
<dt>MaxTemperatureMapper.java</dt>
<dd>extends Mapper, overrides map function taking in key, value and context, parse records</dd>
<dt>MaxTemperatureReducer.java</dt>
<dd>extends Reducer, overrides reduce function taking in key, values, context, computes max</dd>

###Hadoop parameters
<b>map(key, value, context)</b><br>
	key: input key<br>
	value: input value (one record)<br>
	context: write to emit year and temperature<br>
	
<b>reduce(key, values, context)</b><br>
	key: year<br>
	values: temperatures of one year<br>
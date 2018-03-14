package com.tju.storm.wordcount.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 * ��Ϣ��׼������
 * */

public class WordNormalizerBolt implements IRichBolt{

	private OutputCollector outputCollector;
	
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

	//ִ�ж��ĵ�Tuple�߼�����ķ���
	public void execute(Tuple input) {
		// TODO Auto-generated method stub
		String sentence = input.getString(0);
		String[] words = sentence.split(" ");
		
		for(String word:words){
			outputCollector.emit(new Values(words));
		}
	}

	//bolt��ʼ������
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		// TODO Auto-generated method stub
		outputCollector = collector;
	}

	//�ֶ�����
	public void declareOutputFields(OutputFieldsDeclarer declare) {
		// TODO Auto-generated method stub
		declare.declare(new Fields("word"));
	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.tju.storm.wordcount.spout;

import java.util.Map;
import java.util.Random;

import javax.rmi.CORBA.UtilDelegate;


import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

//�������һ��������Ϣ
public class RandomSentenceSpout extends BaseRichSpout{
	
	SpoutOutputCollector spoutOutputCollector;
	Random random;

	public void nextTuple() {
		// TODO Auto-generated method stub
		Utils.sleep(2000);
		String[] sentences = new String[]{};
		String sentence = sentences[random.nextInt(sentences.length)];
		//ʹ��emit��������tuple����
		spoutOutputCollector.emit(new Values(sentence.trim().toLowerCase()));
	}
	
	//��Ϣ��֤�����е�ackȷ�Ϸ���
	public void ack(Object id){
	}
	
	//��Ϣ��֤�����е�failȷ�Ϸ���
	public void fail(Object id){
	}

	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		spoutOutputCollector = collector;
		random = new Random();
	}

	//�ֶ�����
	public void declareOutputFields(OutputFieldsDeclarer declare) {
		// TODO Auto-generated method stub
		declare.declare(new Fields("word"));
	}
	

}

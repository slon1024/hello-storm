package spouts;

import java.util.Map;

import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;

public class ItemGenerator extends BaseRichSpout {

  @Override
  public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
  }

  @Override
  public void nextTuple() {
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
  }
}

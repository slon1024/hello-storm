package spouts;

import java.util.Map;

import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Values;
import backtype.storm.tuple.Fields;

public class ItemGenerator extends BaseRichSpout {
  private SpoutOutputCollector _collector;
  private boolean completed = false;

  @Override
  public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
    _collector = collector;
  }

  @Override
  public void nextTuple() {
    if(false == completed)
      _collector.emit(new Values("Hello storm"));
    completed = true;
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    declarer.declare(new Fields("message"));
  }
}

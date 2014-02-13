package bolts;

import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.tuple.Tuple;

public class TransformerBolt extends BaseBasicBolt {

  @Override
  public void execute(Tuple input, BasicOutputCollector collector) {
    String message = input.getString(0);
    System.out.println("message: " + message);
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
  }

  @Override
  public void cleanup() {
    System.out.println("=== TransformerBolt -> cleanup() ===");
  }
}

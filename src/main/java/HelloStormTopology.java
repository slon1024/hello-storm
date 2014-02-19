import backtype.storm.topology.TopologyBuilder;
import backtype.storm.LocalCluster;
import backtype.storm.Config;
import backtype.storm.generated.StormTopology;

import spouts.ItemGenerator;
import bolts.TransformerBolt;

public class HelloStormTopology {
  public static void main(String[] args) throws InterruptedException {
    org.apache.log4j.Logger.getRootLogger().removeAllAppenders();

    TopologyBuilder builder = getBuilder();
    runCluster("storm-hello-topology", getConfig(), builder.createTopology());
  }

  private static TopologyBuilder getBuilder() {
    TopologyBuilder builder = new TopologyBuilder();
    builder.setSpout("item-generator", new ItemGenerator());
    builder.setBolt("transformer-bolt", new TransformerBolt())
      .shuffleGrouping("item-generator");

    return builder;
  }

  private static Config getConfig() {
    Config conf = new Config();
    conf.setDebug(false);
    return conf;
  }

  private static void runCluster(String name, Config conf, StormTopology stormTopology) 
    throws InterruptedException {

    LocalCluster cluster = new LocalCluster();
    cluster.submitTopology(name, conf, stormTopology);
    Thread.sleep(1000);
    cluster.shutdown();
  }

}

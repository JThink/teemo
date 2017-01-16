package com.jthink.teemo.configuration

import com.jthink.teemo.properties.TaskProperties
import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * jthink company
  *
  * @author jthink
  * @version 0.0.1
  */
@Configuration
class SparkConfiguration {

  @Autowired
  @transient
  var taskProperties: TaskProperties = _

  @Bean
  def sparkContext(): SparkContext = {
    val conf = new SparkConf().setAppName(this.taskProperties.getName)
    val sc = new SparkContext(conf)
    sc
  }
}

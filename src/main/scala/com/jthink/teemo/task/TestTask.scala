package com.jthink.teemo.task

import com.jthink.teemo.properties.TaskProperties
import org.apache.spark.SparkContext
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * jthink company
  *
  * 算法具体逻辑
  *
  * @author jthink
  * @version 0.0.1
  */
@Component
class TestTask extends Task {

  private val LOGGER: Logger = LoggerFactory.getLogger(classOf[TestTask])

  @Autowired
  @transient
  var taskProperties: TaskProperties = _

  @Autowired
  @transient
  var sparkContext: SparkContext = _

  /**
    * 具体的业务逻辑
    */
  override def doTask(): Unit = {
    LOGGER.info("task test start")
    // TODO: 具体的业务逻辑
    LOGGER.info("task test stop")
  }

}

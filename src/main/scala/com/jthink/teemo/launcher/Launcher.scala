package com.jthink.teemo.launcher

import com.jthink.teemo.properties.TaskProperties
import com.jthink.teemo.task.TestTask
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.{ComponentScan, PropertySource}

/**
  * jthink company
  *
  * 项目启动器
  *
  * @author jthink
  * @version 0.0.1
  */
@SpringBootApplication
@ComponentScan(basePackages = Array("com.jthink.teemo"))
//@PropertySource(Array("file:/the/file/location/teemo/teemo.properties"))
@PropertySource(Array("classpath:properties/teemo.properties"))
@EnableConfigurationProperties(Array(classOf[TaskProperties]))
class Launcher {
}

object Launcher {
  private val TASK_MAPPING = Map("test" -> classOf[TestTask])
  private val LOGGER: Logger = LoggerFactory.getLogger(classOf[Launcher])

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      LOGGER.info("参数不对, 参数如下:")
      LOGGER.info("参数1: 需要执行的task name")
    } else {
      val t = args(0).toString
      if (!TASK_MAPPING.contains(t)) {
        LOGGER.info("task 不存在")
      } else {
        val context: ConfigurableApplicationContext = new SpringApplicationBuilder(classOf[Launcher]).run(args: _*)
        LOGGER.info("teemo start successfully")
        val task = context.getBean(TASK_MAPPING.get(t).get)
        // 开始执行具体的业务
        task.doTask()
      }
    }
  }
}

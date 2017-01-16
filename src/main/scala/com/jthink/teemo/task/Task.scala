package com.jthink.teemo.task

/**
  * jthink company
  *
  * spark任务的父类
  * @author jthink
  * @version 0.0.1
  */
trait Task extends Serializable {

  def doTask()
}

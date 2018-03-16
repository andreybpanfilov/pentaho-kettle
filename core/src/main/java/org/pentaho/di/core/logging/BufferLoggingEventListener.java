package org.pentaho.di.core.logging;

public class BufferLoggingEventListener implements KettleLoggingEventListener {

  @Override
  public void eventAdded(KettleLoggingEvent event) {
    Object messageObject = event.getMessage();
    if ( messageObject instanceof LogMessage ) {
      String logChannelId = ((LogMessage) messageObject).getLogChannelId();
      LogChannelFileWriterBuffer fileWriter = LoggingRegistry.getInstance().getLogChannelFileWriterBuffer(logChannelId);
      if ( fileWriter != null ) {
        fileWriter.addEvent(event);
      }
    }
  }

}

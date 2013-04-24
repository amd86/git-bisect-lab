package edu.syr.bytecast.interp.amd64;

import java.util.ArrayList;
import java.util.List;

public class PrintStatements {
  
  private static PrintStatements m_instance;
  
  public synchronized static void reset(){
    m_instance = null;
  }
  
  public synchronized static PrintStatements v(){
    if(m_instance == null){
      m_instance = new PrintStatements();
    }
    return m_instance;
  }
  
  private List<String> m_execLines;
  
  private PrintStatements(){
    m_execLines = new ArrayList<String>();
  }
  
  public void println(String line){
    m_execLines.add(line);
  }
  
  public List<String> getExecLines(){
    return m_execLines;
  }
}

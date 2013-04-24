
package bytecast.interp.test;

import java.util.List;

public class TestResult {
  
  private int m_ret;
  private List<String> m_execLines;
  
  public TestResult(int ret, List<String> exec_lines){
    m_ret = ret;
    m_execLines = exec_lines;
  }
  
  public int getRet(){
    return m_ret;
  }
  
  public List<String> getExecLines(){
    return m_execLines;
  }
  
  @Override 
  public boolean equals(Object other){
    if(other instanceof TestResult == false){
      return false;
    }
    TestResult rhs = (TestResult) other;
    if(m_ret != rhs.m_ret){
      return false;
    }
    if(m_execLines.size() != rhs.m_execLines.size()){
      return false;
    }
    for(int i = 0; i < m_execLines.size(); ++i){
      String lhs_line = m_execLines.get(i);
      String rhs_line = rhs.m_execLines.get(i);
      if(lhs_line.equals(rhs_line) == false){
        return false;
      }
    }
    return true;
  }
  
  @Override
  public String toString(){
    return "[m_ret: "+m_ret+", m_execLines: {"+m_execLines.toString()+"}]";
  } 
}


package bytecast.interp.test;

import java.util.ArrayList;
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
    return trimStrings(m_execLines);
  }
  
  private List<String> trimStrings(List<String> input){
    List<String> ret = new ArrayList<String>();
    for(String str : input){
      String curr_str = str.trim();
      if(curr_str.equals("")){
        continue;
      }
      ret.add(curr_str);
    }
    return ret;
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
    if(getExecLines().size() != rhs.getExecLines().size()){
      return false;
    }
    for(int i = 0; i < getExecLines().size(); ++i){
      String lhs_line = getExecLines().get(i);
      String rhs_line = rhs.getExecLines().get(i);
      if(lhs_line.equals(rhs_line) == false){
        return false;
      }
    }
    return true;
  }
  
  @Override
  public String toString(){
    return "[m_ret: "+m_ret+", m_execLines: {"+getExecLines().toString()+"}]";
  } 
}

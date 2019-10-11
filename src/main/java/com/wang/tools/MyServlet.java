package com.wang.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class MyServlet extends GenericServlet{
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		this.request=(HttpServletRequest) req;
		this.response=(HttpServletResponse) res;
		setRequest(request);
		setResponse(response);
		initFields();
		fillParams();
		executeService(req,res);
		
	}
	/**
	 * 
	 * Get and Set  Start
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public abstract void executeService(ServletRequest req, ServletResponse res) ;
	/**
	 * 
	 * Get and Set  End
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void sendRequestDispatcher(String destination) throws ServletException, IOException {
		request.getRequestDispatcher(destination).forward(request, response);
	}
	
	
	public void sendRedire(String destination,String param) throws IOException {
		response.sendRedirect(destination+"?"+param);
	}
	/**
	 * 
	 * 向浏览器输出数据
	 * @param str  输出的内容
	 * @throws IOException
	 */
	public void writeOut(String str) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.append(str);
		writer.flush();
		writer.close();
	}
	/**
	 * 初始化对象的属性
	 */
	public void initFields() {
		System.out.println("myservlet initFields start!");
		// TODO Auto-generated method stub
		Field[] Fields = this.getClass().getDeclaredFields();
		for (Field field : Fields) {
			Class type = field.getType();
			field.setAccessible(true);
			if(type==int.class||type==Integer.class) {
				try {
					field.set(this, 0);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(type==long.class||Long.class==type) {
				try {//如果字段的修饰符是静态的就返回，重新循环
					if (Modifier.isStatic(field.getModifiers())) {
						break;
					}
					field.set(this, 0l);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(type==double.class||Double.class==type) {
				try {//如果字段的修饰符是静态的就返回，重新循环
					if (Modifier.isStatic(field.getModifiers())) {
						break;
					}
					field.set(this, 0);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(type==int[].class||Integer[].class==type) {
				try {
					
					field.set(this, new int[] {});
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(type==long[].class||Long[].class==type) {
				try {

					field.set(this, new long[] {});
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else  {
				try {
					
					field.set(this, null);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("myservlet initFields end!");
	}
	
	/**
	 * 将提交过来的参数封装到该对象的属性中
	 */
	public void fillParams() {
		System.out.println("myservlet fillParams start!");
		// TODO Auto-generated method stub
		//map里面的是String ：String []的形式
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			//打印出获取到的参数
//			System.out.println(key+" : "+Arrays.toString(parameterMap.get(key)));
			//先把key对应的String [] 值存到String数组中去
			String[] values = parameterMap.get(key);
			//因为是通过表单的name值与类的属性名相对应的
			//所以利用反射，先获取到该类的所有字段Fields
			//判断name值与Field的参数是否相同来注入表单name对应的value到该类的字段上
			Field field=null;
			try {
				field = this.getClass().getDeclaredField(key);
				field.setAccessible(true);
				Class type = field.getType();
//				System.out.println("type="+type);
				//如果获取的参数是一个值的
				if(values.length==1) {
					//如果该类的该字段的类型是Integer或者int类型的时候
					if(type==int.class||Integer.class==type) {
						try {
							System.out.println("int="+values[0]);
							field.set(this, Integer.parseInt(values[0]));
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("int 单个的类型转换失败！");
						}
						
					}
					//如果该类的该字段的类型是Long或者long类型的时候
					else if(type==Long.class||long.class==type) {
						try {
							System.out.println("long="+values[0]);
							field.set(this, Long.parseLong(values[0]));
						} catch (Exception e) {
							System.out.println("long 单个的类型转换失败！");
						}
						
					}
					else if(type==double.class||Double.class==type) {
						try {//如果字段的修饰符是静态的就返回，重新循环
							if (Modifier.isStatic(field.getModifiers())) {
								break;
							}
							System.out.println("double="+values[0]);
							field.set(this, Double.parseDouble(values[0]));
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if((type==Date.class||java.sql.Date.class==type)) {
						if(values[0].trim().equals("")) {
							break;
						}
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						try {		
								System.out.println("data="+sdf.parse(values[0]));
								field.set(this, sdf.parse(values[0]));
							
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("日期非法参数错误！");
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("日期转换错误！");
						}
						catch (Exception e) {
							System.out.println("Date 单个的类型转换失败！");
						}
					}
					else if(type==String [].class) {
						String [] temp=new String[1];
						temp[0]=values[0];
						System.out.println("Lstring="+values[0]);
						field.set(this, temp);
					}
					//如果该类的该字段的里欸选哪个是String的类型的时候
					else {
						System.out.println("string="+values[0]);
						field.set(this, values[0]);
						
					}
					
				}
				//如果获取的参数值有一个以上的
				else {
						List <String>list=new ArrayList<String>();
						//去掉‘’空字符
						for (int i = 0; i < values.length; i++) {
							if(!"".equals(values[i].trim())) {
								list.add(values[i].trim() );
							}
						}
						if(int[].class==type||Integer[].class==type) {
							int temp[]=new int[list.size()];
							for (int i = 0; i < temp.length; i++) {
								try {
									temp[i]=Integer.parseInt(list.get(i));
									System.out.println("int="+list.get(i)+" : "+i);
								} catch (Exception e) {
									System.out.println("int数组的类型转换失败！");
								}
							}
							field.set(this, temp);
						}
						else {
							String [] temp=new String[list.size()];
							for (int i = 0; i < list.size(); i++) {
								temp[i]=list.get(i);
								System.out.println("int="+list.get(i)+" : "+i);
							}
							field.set(this, temp);
						}
				}
				
			} 
			catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NoSuchFieldException e) {
				e.printStackTrace();
				System.out.println("没有该字段："+field);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("myservlet fillParams end!");
	}

}

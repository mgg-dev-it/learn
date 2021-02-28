# $ python -m pip install selenium
# https://www.javatpoint.com/selenium-python
# https://www.guru99.com/selenium-python.html
# https://www.geeksforgeeks.org/selenium-python-tutorial/

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time  
from selenium.webdriver.common.keys import Keys  
print("sample test case started")

options = Options()
#options.add_argument("--disable-extensions")
#options.set_headless(headless=True)
#options.headless = True
options.add_argument("--headless")
driver = webdriver.Chrome(options=options)


#driver = webdriver.Chrome()  
#driver=webdriver.firefox()  
#driver=webdriver.ie()  

#maximize the window size  
#driver.maximize_window()  

#navigate to the url  
driver.get("https://www.google.com/")  

#identify the Google search text box and enter the value  
driver.find_element_by_name("q").send_keys("javatpoint")  

time.sleep(3)  

#click on the Google search button  
driver.find_element_by_name("btnK").send_keys(Keys.ENTER)  

time.sleep(3)  

#close the browser  
driver.close()  
print("sample test case successfully completed")  
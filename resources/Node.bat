set HERE=%CD%
set SELENIUM_VERSION=3.141.59
set HUB_URL=http://localhost:4444/grid/register
set CHROME_DRIVER_LOC=%HERE%/chromedriver.exe
set IE_DRIVER_LOC=%HERE%/IEDriverServer.exe
set FF_Driver_LOC=%HERE%/geckodriver.exe
start java -Dwebdriver.chrome.driver=%CHROME_DRIVER_LOC% -Dwebdriver.ie.driver=%IE_DRIVER_LOC% -Dwebdriver.gecko.driver=%FF_Driver_LOC% -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -role node -hub %HUB_URL% -port 5566
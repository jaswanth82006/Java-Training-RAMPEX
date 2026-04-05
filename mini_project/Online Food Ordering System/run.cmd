@echo off
echo ==============================================
echo Compiling Online Food Ordering System...
echo ==============================================

if not exist bin (
    mkdir bin
)

javac -d bin com\foodorder\models\*.java com\foodorder\exceptions\*.java com\foodorder\payments\*.java com\foodorder\main\*.java

if %errorlevel% neq 0 (
    echo Compilation failed! Please check for errors.
    del sources.txt
    pause
    exit /b %errorlevel%
)

echo.
echo Compilation successful.
echo.
del sources.txt

echo ==============================================
echo Running Online Food Ordering System...
echo ==============================================
echo.

java -cp bin com.foodorder.main.FoodOrderingSystem

echo.
echo.

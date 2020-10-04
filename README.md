# CSV2Historian
preparing csv file for AVEVA (Wonderware) Historian
script was tested on Historian 2017 u3, but it also works for any version WW Historian

1. for Wonderware Historian use  prepareDataForWWHistorian()
2. it uses Analog_1...Analog_N tag's names - so these tags should be created on your Wonderware (AVEVA) Historian
3. script creates N *.csv files in "output" folder. These files can be copied to WW Historian import folder on yoyr machine

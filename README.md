# CardioSmart
Prototype App for HOSA Medical Innovation 2019. More information [here.](https://docs.google.com/document/d/1pLR8QUFnIHLA7SvDt51z2ykeINMfY8b3HCHsPQwdz8s/edit?usp=sharing) 

## Overview
A 2003 study shows that analyzing Heart Rate Variability (HRV) can be the key to predict sudden cardiac death
in Chronic Heart Failure patients (source). In recent years, the widespread availability of smartwatches has made
HRV data extremely accessible and reliable. We propose a system consisting of a smartwatch heart rate sensor, 
a machine learning model, and a smartphone app that alerts the user to an impending cardiac arrest.

## Innovation
Our innovation is a mobile app which connects via bluetooth to the patient's smartwatch. When the patient is in a stable
resting position (sleep), the app will begin logging the patient’s heart rate data. After enough data is collected, the app
computes heart rate variability as well as the low frequency power (LFP) of the heart rate variability. Based on the HRV 
and LFP, the app will calculate the patient’s risk of having a heart attack. If the risk is sufficiently high, 
a notification will be sent to the patient’s emergency contacts, and the patient will be instructed to seek medical attention. 

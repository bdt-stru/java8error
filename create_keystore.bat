@rem -alias somealias 
keytool -genkey -v -keystore unimportant_weak.keystore -storepass somepassstore -keypass somepasskey -keyalg RSA -keysize 512 -validity 10000
@pause

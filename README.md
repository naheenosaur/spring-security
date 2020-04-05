## jwt 키 생성
1. jdk\bin 폴더에서 key tool로 jks파일 생성  
   `keytool -genkeypair -alias server -keyalg RSA -keypass 비밀번호 -keystore server.jks -storepass 비밀번호 -deststoretype pkcs12`
2. __application.properties__ 의 __key.store.factory.password__ 항목에 생성한 password 입력
3. [jwt로 발급된 토큰정보 확인](https://jwt.io/)

## database schema
__resources\db\migration__ 에 추가

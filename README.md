# mini-project
비트캠프 2차 미니 프로젝트


## 결혼정보회사 회원 관리 시스템

### 기능
1. 회원 등록
    - 새로운 회원 정보를 저장한다.
    - 아이디, 비밀번호, 이름, 성별, 나이, 전화번호, 취미, 성격, 등록일
      (id, password, name, gender, age, tel, hobby, personal, registeredDate)

2. 전체 회원 조회
    - 저장된 모든 회원을 조회한다.

3. 여성 회원
    - 저장된 회원 중 여성 회원의 정보를 조회한다.

4. 남성 회원
    - 저장된 회원 중 남성 회원의 정보를 조회한다.

5. 회원 상세 보기
    - 저장된 회원 중 한 명을 선택해서 상세 정보를 조회한다.

6. 회원 탈퇴
    - 저장된 정보에서 특정 회원의 정보를 삭제한다.

7. 회원 매칭
    - 좋아하는 이성의 성격을 선택하여 걸맞는 상대 정보를 제공한다.


### 디폴트 회원 리스트
1. 여성 회원 (9명)
{"id":"kimth","password":"1111","name":"김태희","gender":1,"age":30,"tel":"010-1111-1111","hobby":"피규어 수집","personal":1,"registeredDate":"01월 10, 2019"}

{"id":"youjy","password":"1111","name":"유지연","gender":1,"age":33,"tel":"010-2222-2222","hobby":"맛집 탐방","personal":2,"registeredDate":"05월 20, 2019"}

{"id":"eomjh","password":"1111","name":"엄정화","gender":1,"age":25,"tel":"010-3333-3333","hobby":"퍼즐맞추기","personal":3,"registeredDate":"10월 01, 2020"}

{"id":"jeonjh","password":"1111","name":"전지현","gender":1,"age":40,"tel":"010-4444-4444","hobby":"돈까스먹기","personal":4,"registeredDate":"03월 11, 2020"}

{"id":"junghh","password":"1111","name":"정현희","gender":1,"age":34,"tel":"010-5555-5555","hobby":"요리","personal":5,"registeredDate":"10월 10, 2020"}

{"id":"iu","password":"1111","name":"아이유","gender":1,"age":24,"tel":"010-6666-6666","hobby":"불우이웃돕기","personal":6,"registeredDate":"12월 20, 2019"}

{"id":"baedn","password":"1111","name":"배두나","gender":1,"age":37,"tel":"010-7777-7777","hobby":"범인검거","personal":7,"registeredDate":"08월 10, 2020"}

{"id":"jessica","password":"1111","name":"제시카","gender":1,"age":37,"tel":"010-8888-8888","hobby":"음주","personal":8,"registeredDate":"10월 01, 2020"}

{"id":"leehr","password":"1111","name":"이효리","gender":1,"age":40,"tel":"010-9999-9999","hobby":"댄스파티","personal":9,"registeredDate":"07월 10, 2020"}

2. 남성 회원 (9명)


3. member.json 파일에 저장할 내용


### Ascii Art

╱▔▔╲╱▔▔╲┊┊╭━━━━━━━━━━━━
▏┈╭╮╭╮┈▕┊┊┃ Finding
╲┈┏━━┓┈╱┊╭┫ your Love♥
┊╲╰━━╯╱━━╯╰━━━━━━━━━━━━
┊┊╲┈┈╱┊┊┊┊┊┊┊┊  ♥    ♥
┊┊┊╲╱┊┊┊┊┊┊┊┊┊♥    ♥   ♥

 _                
| |               
| |__  _   _  ___ 
| '_ \| | | |/ _ \
| |_) | |_| |  __/
|_.__/ \__, |\___|
        __/ |     
       |___/    
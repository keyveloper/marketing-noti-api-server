# IntelliJ HTTP Client 테스트 가이드

## HTTP Client 파일 위치
```
src/main/resources/http-client/
├── noti-to-advertiser.http
└── noti-to-influencer.http
```

## 사용 방법

### 1. 서버 실행
먼저 Spring Boot 애플리케이션을 실행합니다:
```bash
./gradlew bootRun
```

또는 IntelliJ에서:
- `MarketingNotiApiServerApplication.kt` 파일을 열고
- `main` 함수 옆의 ▶️ 버튼 클릭

### 2. HTTP 파일 열기
IntelliJ에서 `.http` 파일을 엽니다:
- `src/main/resources/http-client/noti-to-advertiser.http`
- `src/main/resources/http-client/noti-to-influencer.http`

### 3. API 요청 실행

#### 방법 1: 개별 요청 실행
1. 실행하고 싶은 요청 위에 마우스를 올립니다
2. 요청 옆에 나타나는 **▶️ Run** 버튼을 클릭합니다
3. 또는 요청 안에 커서를 놓고 **Ctrl + Enter** (Windows/Linux) 또는 **Cmd + Enter** (Mac)를 누릅니다

#### 방법 2: 모든 요청 실행
1. 파일 상단의 **▶️ Run All Requests in File** 버튼 클릭
2. 모든 요청이 순차적으로 실행됩니다

### 4. 응답 확인
- 요청 실행 후 우측 패널에 응답이 표시됩니다
- Response Status, Headers, Body를 확인할 수 있습니다
- 하단 **Run** 탭에서도 응답 이력을 확인할 수 있습니다

---

## API 엔드포인트

### NotiToAdvertiser API

#### 1. POST - 알림 생성
```http
POST http://localhost:8080/api/v1/noti-to-advertiser
Content-Type: application/json

{
  "message": "새로운 팔로워가 생겼습니다!",
  "advertiserId": "550e8400-e29b-41d4-a716-446655440001",
  "notiToAdvertiserType": "NEW_FOLLOWER"
}
```

**NotiToAdvertiserType 종류:**
- `NEW_FOLLOWER` - 새로운 팔로워
- `NEW_AD_LIKE` - 광고 좋아요
- `NEW_DM` - 새로운 DM
- `NEW_AD_APPLICATION` - 새로운 광고 신청

#### 2. GET - 광고주별 알림 조회
```http
GET http://localhost:8080/api/v1/noti-to-advertiser/advertiser/{advertiserId}
```

---

### NotiToInfluencer API

#### 1. POST - 알림 생성
```http
POST http://localhost:8080/api/v1/noti-to-influencer
Content-Type: application/json

{
  "message": "리뷰가 승인되었습니다!",
  "influencerId": "660e8400-e29b-41d4-a716-446655440001",
  "notiToInfluencerType": "ACCEPT_REVIEW"
}
```

**NotiToInfluencerType 종류:**
- `ACCEPT_REVIEW` - 리뷰 승인
- `NEW_DM` - 새로운 DM
- `AD_DEADLINE` - 광고 마감일

#### 2. GET - 인플루언서별 알림 조회
```http
GET http://localhost:8080/api/v1/noti-to-influencer/influencer/{influencerId}
```

---

## 테스트 시나리오

### 시나리오 1: 광고주 알림 생성 및 조회
1. `noti-to-advertiser.http` 파일 열기
2. "1. Create NotiToAdvertiser - NEW_FOLLOWER" 실행
3. "2. Create NotiToAdvertiser - NEW_AD_LIKE" 실행
4. "5. Get NotiToAdvertisers by AdvertiserId" 실행하여 생성된 알림 확인

### 시나리오 2: 인플루언서 알림 생성 및 조회
1. `noti-to-influencer.http` 파일 열기
2. "1. Create NotiToInfluencer - ACCEPT_REVIEW" 실행
3. "2. Create NotiToInfluencer - NEW_DM" 실행
4. "4. Get NotiToInfluencers by InfluencerId" 실행하여 생성된 알림 확인

---

## UUID 사용 안내

테스트 파일에 사용된 UUID들:

### Advertiser IDs
- `550e8400-e29b-41d4-a716-446655440001` (테스트용 광고주 1)
- `550e8400-e29b-41d4-a716-446655440002` (테스트용 광고주 2)

### Influencer IDs
- `660e8400-e29b-41d4-a716-446655440001` (테스트용 인플루언서 1)
- `660e8400-e29b-41d4-a716-446655440002` (테스트용 인플루언서 2)

필요시 새로운 UUID를 생성하여 사용할 수 있습니다:
- 온라인 UUID 생성기: https://www.uuidgenerator.net/
- Kotlin 코드: `UUID.randomUUID()`

---

## 문제 해결

### 1. Connection refused
**원인**: 서버가 실행되지 않음
**해결**: Spring Boot 애플리케이션 실행 확인

### 2. 404 Not Found
**원인**: URL 경로가 잘못됨
**해결**: 엔드포인트 경로 확인 (`/api/v1/noti-to-advertiser`)

### 3. 400 Bad Request
**원인**: 요청 데이터 형식 오류
**해결**:
- UUID 형식 확인 (하이픈 포함 36자)
- JSON 형식 확인
- Enum 값 확인 (대소문자 구분)

### 4. 500 Internal Server Error
**원인**: 서버 내부 에러
**해결**:
- 데이터베이스 연결 확인
- 서버 로그 확인
- application.yaml의 DB 설정 확인

---

## IntelliJ HTTP Client 고급 기능

### 환경 변수 사용
`http-client.env.json` 파일 생성:
```json
{
  "dev": {
    "baseUrl": "http://localhost:8080",
    "advertiserId": "550e8400-e29b-41d4-a716-446655440001"
  },
  "prod": {
    "baseUrl": "https://api.production.com",
    "advertiserId": "real-uuid-here"
  }
}
```

HTTP 파일에서 사용:
```http
POST {{baseUrl}}/api/v1/noti-to-advertiser
{
  "advertiserId": "{{advertiserId}}"
}
```

### 응답 저장
```http
POST http://localhost:8080/api/v1/noti-to-advertiser
Content-Type: application/json

> {%
    client.test("Status is 200", function() {
        client.assert(response.status === 200);
    });
    client.global.set("notiId", response.body.result.notiToAdvertiserMetadata.id);
%}
```

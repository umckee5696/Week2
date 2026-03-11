# UMC HSU 10th - Android
UMC HSU 10기 Android 스터디 레포지토리입니다.

---

## ⚠️ 주의사항

### 1. .gitkeep 파일 관리
- **절대 .gitkeep 파일을 삭제하지 마세요**
- 빈 폴더를 Git에서 관리하기 위해 필요한 파일입니다

### 2. 브랜치 관리
- main 브랜치에서 직접 작업하지 마세요
- 반드시 본인의 브랜치에서만 작업합니다
- 다른 사람의 브랜치를 임의로 수정하지 마세요

### 3. 머지 규칙
- 피드백이 완전히 반영되기 전까지 머지하지 마세요
- 승인 없이 다른 사람의 PR을 머지하지 마세요

---

## 🔄 작업 방식

### 1단계: 브랜치 생성
```bash
# main 브랜치 기반으로 브랜치 생성
git checkout main
git pull origin main
git checkout -b <주차/닉네임> ex: git checkout -b Week00/Wendy
```

### 2단계: 작업 수행
- 본인 브랜치에서만 작업합니다
- 주차별 미션을 수행하고 커밋합니다

### 3단계: PR(Pull Request) 생성
- main 브랜치로 PR을 올립니다
- PR 제목: `Create Week{주차} Mission{번호}`
- 예시: `Create Week1 Mission1`

### 4단계: 피드백 반영 및 머지
1. 리뷰어의 피드백을 받습니다
2. 피드백 내용을 반영하여 수정합니다
3. 모든 피드백이 반영되면 **스스로 머지**합니다

```

---

## 📁 폴더 구조

### 기본 구조
```
Week00/
├── UMC 닉네임 ex: Wendy
├── .gitkeep
```

### 폴더 생성 규칙
1. **주차 폴더**: Week00 ~ Week10 (제가 생성하기 때문에 주차 폴더는 건드리지 마세요!!!)
2. **개인 폴더**: 본인의 UMC 닉네임으로 생성

---

## 📖 GitHub 사용 방법

### 기본 Git 명령어
```bash
# 현재 브랜치 확인
git branch

# 변경사항 확인
git status

# 파일 추가
git add .

# 커밋
git commit -m "커밋 메시지"

# 푸시
git push origin Week주차/닉네임
```

---
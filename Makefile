build:
	@echo "Start Build"
	set -e
	@./gradlew assembleDebug

install: build
	@echo "Install apk"
	@./gradlew installDebug

.PHONY: build install

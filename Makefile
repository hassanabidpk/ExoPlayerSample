build:
	@echo "Start Build"
	set -e
	@./gradlew assembleDebug

install: build
	@echo "Install apk"
	@./gradlew installDebug
	@adb shell am start -n com.hassanabid.android.exoplayersample/.MainActivity

.PHONY: build install

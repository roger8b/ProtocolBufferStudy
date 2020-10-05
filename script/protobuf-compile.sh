cd $(dirname $0)
SRC_DIR=../src/main/resources/
DST_DIR=../src/main/java/
protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto

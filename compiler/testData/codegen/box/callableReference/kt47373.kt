// IGNORE_BACKEND: JVM_IR
// JVM IR status: throwing exception because of FE, see KT-47373
// IGNORE_BACKEND_FIR: JVM_IR
// FIR status: reported proper error, move into diagnostic tests after fixing the BE exception

val any = Array!!<Any>::class
DESCRIPTION = "Core Python libraries ported to MicroPython"
HOMEPAGE = "https://github.com/micropython/micropython-lib"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b4c9cf84e44b0961b744ae0ca6617ae6"

inherit autotools

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
	https://github.com/micropython/micropython-lib/archive/v${PV}.tar.gz;name=src \
"

SRC_URI[src.sha256sum] = "66e15380eb109613263beb6825b8eecb9191088270c1a59e8c7d922dd57183c7"

RDEPENDS_${PN} = "micropython"
RDEPENDS_${PN}-native = "micropython-native"

do_compile() {
	:
}

do_configure() {
	:
}

do_install() {
	oe_runmake -C ${S} PREFIX=${B} install	
	install -d ${D}${libdir}/micropython
	cp -r --preserve=mode,links ${B}/* ${D}${libdir}/micropython/
}

FILES_${PN} = " \
	${libdir}/micropython/* \
"

BBCLASSEXTEND = "native"

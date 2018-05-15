FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"
USE_BOOTSRC ?= "0"

inherit uboot-boot-scr

DEPENDS += "u-boot-mkimage-native atf-native"
SRC_URI_append =  " file://0001-mmc-avoid-division-by-zero-in-meson_mmc_config_clock.patch"

SRC_URI_append_odroid-c2 = "\
    file://odroid-c2/aml_encrypt_gxb \
    file://odroid-c2/bl2.package  \
    file://odroid-c2/bl301.bin \
    file://odroid-c2/bl30.bin \
    file://odroid-c2/bl31.bin \
    file://0001-Add-default-bootargs.patch \
    "

do_compile_append_odroid-c2 () {

        fip_create --bl30 ${WORKDIR}/odroid-c2/bl30.bin --bl301 ${WORKDIR}/odroid-c2/bl301.bin --bl31 ${WORKDIR}/odroid-c2/bl31.bin --bl33 ${B}/${UBOOT_BINARY} ${B}/fip.bin
        fip_create --dump ${B}/fip.bin

        cat ${WORKDIR}/odroid-c2/bl2.package fip.bin > ${B}/boot_new.bin
        ${WORKDIR}/odroid-c2/aml_encrypt_gxb --bootsig --input ${B}/boot_new.bin --output ${B}/${UBOOT_BINARY}.tmp
        dd if=${B}/${UBOOT_BINARY}.tmp of=${B}/${UBOOT_BINARY} bs=512 skip=96
}

COMPATIBLE_MACHINE = "(odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1)"

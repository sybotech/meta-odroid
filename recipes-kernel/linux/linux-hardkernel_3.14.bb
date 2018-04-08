FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "3.14.79"
KBRANCH ?= "odroidc2-3.14.y"
SRCREV ?= "c3e4c730feb1750940971cae9ca1da3ca50f1d56"
KBUILD_DEFCONFIG_odroid-c2 = "odroidc2_defconfig"

require linux-stable.inc
SRC_URI = "\
    git://github.com/hardkernel/linux;branch=${KBRANCH} \
    https://releases.linaro.org/components/toolchain/binaries/4.9-2017.01/aarch64-linux-gnu/gcc-linaro-${LINAROTOOLCHAIN}-x86_64_aarch64-linux-gnu.tar.xz;name=aarch64toolchain;subdir=git \
"
SRC_URI[aarch64toolchain.md5sum] = "631c4c7b1fe9cb115cf51bd6a926acb7"
SRC_URI[aarch64toolchain.sha256sum] = "d1f2761b697e6b49f5db1ec0cd48d2fd98224be8cb5ef182093f691e99c923eb"

EXTRA_OEMAKE_odroid-c2 = 'V=1 CROSS_COMPILE=${TOOLCHAIN_PREFIX} HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

LINAROTOOLCHAIN = "4.9.4-2017.01"
TOOLCHAIN_PREFIX_odroid-c2 = "aarch64-linux-gnu-"
HOST_PREFIX_odroid-c2 = "${TOOLCHAIN_PREFIX}"
PATH_prepend ="${S}/gcc-linaro-${LINAROTOOLCHAIN}-x86_64_aarch64-linux-gnu/bin:"

# Enable 3.5' TFT Screen
#KERNEL_MODULE_AUTOLOAD_append_odroid-c2 = " aml_i2c pwm-meson pwm-ctrl fbtft_device flexfb sx865x "
#module_conf_fbtft_device = "options fbtft_device name=flexpfb rotate=270"
#module_conf_flexfb = "options flexfb chip=ili9488"
#KERNEL_MODULE_PROBECONF += "fbtft_device flexfb"

COMPATIBLE_MACHINE = "(odroid-c2|odroid-c2-hardkernel)"

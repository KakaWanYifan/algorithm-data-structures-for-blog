# Cobb
class Cobb:

    def __init__(self, topStop):
        """
        构造方法
        :param topStop: 陀螺停止
        """
        self.topStop = topStop
        self.prev = None


def GoBack(cobb):
    """
    GoBack
    :param cobb:
    :return:
    """
    # 如果Cobb的陀螺不会停
    if not cobb.topStop:
        # Cobb回到上一层
        cobb = cobb.prev
        return GoBack(cobb) + 1
    else:
        # 如果Cobb的陀螺会停，说明在真实世界，0层
        return 0


if __name__ == '__main__':
    # 定义Cobb的梦
    # 假的Cobb
    fakeCobb = Cobb(False)
    fakeCobb.prev = Cobb(False)
    fakeCobb.prev.prev = Cobb(False)
    fakeCobb.prev.prev.prev = Cobb(False)
    fakeCobb.prev.prev.prev.prev = Cobb(False)
    fakeCobb.prev.prev.prev.prev.prev = Cobb(False)
    fakeCobb.prev.prev.prev.prev.prev.prev = Cobb(False)

    # 真实的Cobb，他的陀螺会停
    realCobb = Cobb(True)
    fakeCobb.prev.prev.prev.prev.prev.prev.prev = realCobb

    # 递归，求Cobb梦的大小
    # fakeCobb开始GoBack
    DreamSize = GoBack(fakeCobb)
    print(DreamSize)

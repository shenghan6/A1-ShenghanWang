# PROG2004 Assessment 1 — 参考项目说明（A1-username）

> 重要：本项目代码仅作为学习参考。作业规范（GenAI Level 2）**禁止**用 GenAI 代写代码、代写注释、制作讲解视频。你必须逐行读懂后自行改写、补充自己的设计与注释，不能原样提交；GitHub 提交记录、WakaTime 计时、讲解视频、GenAI 声明均需本人完成。

## 1. 如何运行

1. 把文件夹名 `A1-username` 改为 `A1-你的MySCU用户名`（例如 `A1-lfolkman`）。
2. 在 IntelliJ IDEA / Eclipse / VSCode 中打开该文件夹，把 `src` 设为源代码目录（Sources Root）。
3. 运行 `src/AssignmentOne.java` 的 `main` 方法，结果打印到控制台。
4. 本机命令行未安装 JDK，如需命令行编译：`javac -d out src/*.java`，再 `java -cp out AssignmentOne`。

## 2. 文件结构与六个 Part 的对应关系

```
A1-username/
└── src/
    ├── AssignmentOne.java        # main 方法，端到端演示（Part 3、Part 6）
    ├── HealthProfessional.java    # 抽象基类：所有医护共有信息/行为（Part 1、Part 2）
    ├── GeneralPractitioner.java   # 子类：全科医生（必选类型，Part 2）
    ├── Specialist.java            # 子类：专科医生（Part 2）
    ├── Nurse.java                 # 子类：护士（Part 2）
    ├── Dietitian.java             # 子类：营养师（Part 2）
    ├── Appointment.java           # 单条预约，实现 Comparable 按时间排序（Part 4）
    ├── AppointmentManager.java    # 预约集合：增 / 查 / 筛 / 排序 / 取消 / 冲突检测（Part 5）
    ├── Day.java                   # 枚举：工作日
    └── TimeSlot.java              # 枚举：08:00–15:30，每 30 分钟一档
```

| 作业部分 | 对应文件与实现要点 |
|---|---|
| Part 1 建模医护 | `HealthProfessional`：ID（纯数字）、姓名、工作日；私有字段 + getter 封装；构造校验非法状态；`toString` 可读输出；重载构造提供默认工作日 |
| Part 2 医护特化 | 四个子类继承抽象基类，各自扩展特有字段；`getRole()` 多态返回类型；基类为 `abstract`，不能被直接实例化 |
| Part 3 操作医护对象 | `AssignmentOne.main` 用 `List<HealthProfessional>` 统一存放不同类型并遍历打印（多态） |
| Part 4 建模预约 | `Appointment`：患者姓名、手机号、医护、时段；构造校验必填项；实现 `Comparable` 支持按时间排序；可关联任意医护类型 |
| Part 5 管理预约集合 | `AppointmentManager`：`ArrayList` 存储；新增时检测同一医护同一时段重复预约；按 ID / 手机号筛选；按时间排序；按 ID+时段或手机号取消；失败返回警告信息 |
| Part 6 操作预约 | `main` 演示正常流程与错误案例：重复订位、取消不存在的预约、非法预约被拦截 |

## 3. 用到的 OOP 概念（视频讲解四大支柱时对照）

- **封装（Encapsulation）**：字段 `private final`，通过 getter 读取；工作日返回不可变视图，外部无法改内部状态。
- **继承（Inheritance）**：四个子类继承 `HealthProfessional`，复用共有代码。
- **多态（Polymorphism）**：统一用 `HealthProfessional` 类型引用不同子类，`getRole()` / `toString()` 在运行时按实际类型响应。
- **抽象（Abstraction）**：`HealthProfessional` 为抽象类，隐藏公共实现细节，只暴露角色行为。
- 其他：`equals/hashCode`（按 ID 判断同一医护）、`Comparable`（预约排序）、枚举（工作日、时段）。

## 4. 设计选择说明（可在作业中讨论）

- 患者信息（姓名、手机号）目前作为 `Appointment` 的字段；Part 4 提出"患者是否应独立成类"是开放设计问题。若你把患者抽成独立 `Patient` 类，需相应调整 `Appointment` 与管理类，并能说明理由。
- 时段用枚举固定下来，方便日后调整诊所排期而不影响预约逻辑。

## 5. 提交前自查清单（对照 Brief）

- [ ] 项目改名为 `A1-username`，压缩为 `A1-username.zip` 上传 MySCU（Blackboard）。
- [ ] GitHub 仓库：定期、有意义地提交；私有仓库需邀请 tutor 和 unit assessor 为协作者；链接写在提交注释里。
- [ ] WakaTime 截图 / 报告，命名 `A1-username-WakaTime.[png/jpg/pdf]`。
- [ ] 讲解视频（≤5 分钟，讲清四大支柱在代码中的位置与选用理由），上传 SCU OneDrive，分享链接写在注释里。
- [ ] GenAI 声明：按是否使用，在注释中粘贴 Brief 里对应的英文声明原文。
- [ ] 补充你自己的 Javadoc 文档注释与行内注释；确保代码风格统一、可读懂。
- [ ] 截止：2026-11-16 23:59；截止后不可补交。

## 6. 可能需要你自行完善 / 核对的点

- 本机未安装 JDK，代码未经实际编译运行；请在 IDE 中跑通并核对控制台输出。
- 手机号校验为 7–15 位数字，可按课程要求调整格式规则。
- 若课程模块 1–3 未讲过某个写法（如模式匹配 `instanceof`、`List.of`），请改成课上讲过的等价写法，避免被标记使用超纲概念。

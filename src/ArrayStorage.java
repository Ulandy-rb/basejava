/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int STORAGE_LIMIT = 10000;

    Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume resume) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(resume.uuid)) {
                    System.out.println("Resume already exist");
                    index = i;
                    break;
                }
            }
            if (index < 0) {
                storage[size] = resume;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        return size;
    }
}
